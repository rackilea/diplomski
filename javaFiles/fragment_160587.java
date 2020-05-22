public class CatchingSoundBytes {

  public static void main(String[] args) {

    try {
      new CatchingSoundBytes().executor();
    } catch (LineUnavailableException ex) {
      ex.printStackTrace();
    }
  }

  public void executor() throws LineUnavailableException {
    int numChannels = 1;
    int numBytesPerSample = 2;
    int sampleRate = 8192;
    boolean endianness = false;
    AudioFormat audioformat = new AudioFormat(sampleRate, 8 * numBytesPerSample, numChannels, true, endianness);
    DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioformat);
    TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
    try {
      targetDataLine.open(audioformat);
      targetDataLine.start();
    } catch (LineUnavailableException ex) {
      System.out.println("ex:" + ex.getMessage());
    }

    int bufferSize = (int) Math.pow(2.0, 11);
    final PipedOutputStream srcSavePOStream = new PipedOutputStream();
    final PipedInputStream snkSavePIStream = new PipedInputStream(bufferSize);
    try {
      snkSavePIStream.connect(srcSavePOStream);
    } catch (IOException ex) {
      System.out.println("ex:" + ex.getMessage());
    }

    String dateFilename = (endianness ? "Big" : "Lit") + new SimpleDateFormat("yyyyMMdd-HHmm").format(new Date());

    // INI Save File
    new Thread(() -> {
      AudioInputStream aisRecording = new AudioInputStream((InputStream) snkSavePIStream, audioformat, AudioSystem.NOT_SPECIFIED);
      File fileRecordedWav = new File("AIS_" + dateFilename + ".wav");
      System.out.println("fileRecordedWav:" + fileRecordedWav.getAbsolutePath());
      try {
        AudioSystem.write(aisRecording, AudioFileFormat.Type.WAVE, fileRecordedWav);
      } catch (IOException ex) {
        System.out.println("Save File -> ex:" + ex.getMessage());
      }
    }).start();
    // END Save File

    BlockingQueue<BytesSound> blockingQueue = new LinkedBlockingQueue<>();
    Stopper stopper = new Stopper();
    stopper.setRunning(true);

    // INI Capture Sound
    new Thread(() -> {
      try {
        long index = 0;
        byte[] buffer = new byte[bufferSize];
        while (stopper.isRunning()) {
          try {
            int count = targetDataLine.read(buffer, 0, bufferSize);
            if (count > 0) {
              byte[] output = new byte[count];
              System.arraycopy(buffer, 0, output, 0, count);
              srcSavePOStream.write(output); // Send to Save Using AudioSystem.write
              blockingQueue.put(new BytesSound(endiannessReorderedBytes(output, audioformat), index)); // Send to Save Using RandomAccessFile
            }
          } catch (Exception ex) {
            System.out.println("Capture Sound -> ex:" + ex.getMessage());
          }
          index++;
          if (index > 1) {
            break;
          }
        }
        targetDataLine.stop();
      } catch (Exception ex) {
        System.out.println("Capture Sound -> ex:" + ex.getMessage());
      } finally {
        try {
          targetDataLine.close();
        } catch (SecurityException e) {
        }
      }
    }).start();
    // END Capture Sound

    // INI Save RandomAccessFile File
    new Thread(() -> {
      String filename = "RAF_" + dateFilename + ".wav";
      System.out.println("raf:" + filename);
      long index = 0;
      while (stopper.isRunning()) {
        try {
          BytesSound bytesSound = blockingQueue.take();
          if (bytesSound instanceof Kill) {
            break;
          }
          //REALLY I don't need to save bytes in this stage,
          //only in order to compare with payload of method using AudioSystem.write
          // I need the bytes and position for processing

          RandomAccessFile raf = new RandomAccessFile(filename, "rw");
          addSample(raf, bytesSound);
          raf.close();
        } catch (Exception ex) {
          System.out.println("Save RandomAccessFile File -> ex:" + ex.getMessage());
        }
        index++;
        if (index > 1) {
          break;
        }
      }
      System.out.println("Expected Size:" + index * bufferSize);
    }
    ).start();
    // END Save RandomAccessFile File

    new Timer(true).schedule(new TimerTask() {
      @Override
      public void run() {
        stopper.setRunning(false);
      }
    }, 4000L);
  }

  private byte[] endiannessReorderedBytes(byte[] incomingBytes, AudioFormat audioformat) {
    if (!(incomingBytes != null && audioformat != null)) {
      throw new IllegalArgumentException("Some arguments are null.");
    }
    byte[] outgoingBytes = new byte[incomingBytes.length];
    if (audioformat.getSampleSizeInBits() == 16) {
      if (incomingBytes.length % 2 != 0) {
        throw new IllegalArgumentException("The size of the byte array does not match the audio format.");
      }
      int count = incomingBytes.length / 2;
      if (audioformat.isBigEndian()) {
        for (int i = 0; i < count; i++) {
          outgoingBytes[i * 2] = incomingBytes[i * 2 + 1];
          outgoingBytes[i * 2 + 1] = incomingBytes[i * 2];
        }
      } else {
        System.arraycopy(incomingBytes, 0, outgoingBytes, 0, incomingBytes.length);
      }
    } else {
      if (audioformat.getEncoding() == Encoding.PCM_SIGNED) {
        for (int i = 0; i < incomingBytes.length; i++) {
          outgoingBytes[i] = (byte) (0x80 ^ incomingBytes[i]);
        }
      } else {
        System.arraycopy(incomingBytes, 0, outgoingBytes, 0, incomingBytes.length);
      }
    }
    return outgoingBytes;
  }


  private void addSample(RandomAccessFile raf, BytesSound bytesSound) {
    try {
      raf.seek(44 /*Header Length*/ + bytesSound.getIndex() * bytesSound.getChunk().length);
      raf.write(bytesSound.getChunk());
    } catch (IOException ex) {
      System.out.println("ex:" + ex.getMessage());
    }
  }

  private class BytesSound {

    private final byte[] chunk;
    private final long index;

    public BytesSound(byte[] chunk, long index) {
      this.chunk = chunk;
      this.index = index;
    }

    public byte[] getChunk() {
      return chunk;
    }

    public long getIndex() {
      return index;
    }

  }

  private class Kill extends BytesSound {

    public Kill(byte[] chunk, long index) {
      super(chunk, index);
    }
  }

  private class Stopper {

    private boolean running;

    public boolean isRunning() {
      return running;
    }

    public void setRunning(boolean running) {
      this.running = running;
    }

  }
}