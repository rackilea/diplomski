import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

public class QHPlayer {

public void play(String f) {
  int k=0;
  AudioFormat targetFormat=null;
  try {
    AudioInputStream audioInputStream=openFile(f);
    targetFormat=audioInputStream.getFormat();
    byte[] data=new byte[1024];
    DataLine.Info dinfo=new DataLine.Info(SourceDataLine.class, targetFormat);
    SourceDataLine line=null;
      line=(SourceDataLine)AudioSystem.getLine(dinfo);
      if(line!=null) {
        line.open(targetFormat);
        line.start();
        while((k=audioInputStream.read(data, 0, data.length))>-1) {
          line.write(data, 0, k);
        }
        line.stop();
        line.close();
    }
  }
  catch(Exception ex) { ex.printStackTrace(); }
}

public void processPlay(String f) {
  int k=0;
  AudioFormat targetFormat=null;
  ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
  try {
    AudioInputStream audioInputStream=openFile(f);
    targetFormat=audioInputStream.getFormat();
    byte[] data=new byte[1024];

    while((k=audioInputStream.read(data, 0, data.length))>-1)
      outputStream.write(data, 0, k);
    byte[] b=outputStream.toByteArray();
    for(k=0; k<b.length; k++) b[k]=(byte)(0.5*b[k]);


    DataLine.Info dinfo=new DataLine.Info(SourceDataLine.class, targetFormat);
    SourceDataLine line=null;
      line=(SourceDataLine)AudioSystem.getLine(dinfo);
      if(line!=null) {
        line.open(targetFormat);
        line.start();
        System.out.println(line.available());
        k=0;
        while(k<b.length) {
        System.out.println(line.available());
          int i=line.write(b, k, 8*1024);
          k+=i;
        }
        }
        line.stop();
        line.close();
  }
  catch(Exception ex) { ex.printStackTrace(); }
}

public void play(byte[] b) {
  int k=0;
  AudioFormat targetFormat=getAudioFormat();
  try {
    DataLine.Info dinfo=new DataLine.Info(SourceDataLine.class, targetFormat);
    SourceDataLine line=null;
      line=(SourceDataLine)AudioSystem.getLine(dinfo);
      if(line!=null) {
        line.open(targetFormat);
        line.start();
        while(k<b.length) {
          int i=line.write(b, k, 8*1024);
          k+=i;
        }
        line.stop();
        line.close();
    }
  }
  catch(Exception ex) { ex.printStackTrace(); }
}



  public AudioInputStream openFile(String file) {
    AudioInputStream audioInputStream=null;
    try {
      File fileIn = new File(file);
      if(file.endsWith(".mp3"))
        audioInputStream=createMp3(fileIn);
      else
        audioInputStream=AudioSystem.getAudioInputStream(fileIn);
    }
    catch(Exception ex) { ex.printStackTrace(); }
    return audioInputStream;
  }


  AudioInputStream createMp3(File fileIn) throws IOException, Exception {
    AudioInputStream audioInputStream=null;
    AudioFormat targetFormat=null;
    try {
      AudioInputStream in=null;
      MpegAudioFileReader mp=new MpegAudioFileReader();
      in=mp.getAudioInputStream(fileIn);
      AudioFormat baseFormat=in.getFormat();
      targetFormat=new AudioFormat(
              AudioFormat.Encoding.PCM_SIGNED,
              baseFormat.getSampleRate(),
              16,
              baseFormat.getChannels(),
              baseFormat.getChannels() * 2,
              baseFormat.getSampleRate(),
              false);
      audioInputStream=AudioSystem.getAudioInputStream(targetFormat, in);
    }
    catch(UnsupportedAudioFileException ue) { System.out.println("\nUnsupported Audio"); }
    return audioInputStream;
  }


  AudioFormat getAudioFormat() {
    float sampleRate = 44100F;
    int sampleSizeInBits = 16;
    int channels = 2;
    boolean signed = true;
    boolean bigEndian = true;
    return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
  }


  public static void main(String args[]) {
    QHPlayer q=new QHPlayer();
    q.processPlay("c:/.....mp3");
  }

}