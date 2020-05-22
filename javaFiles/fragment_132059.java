URL url = new URL(
                          "https://sssss/xxxxx/playback.php?access=subscriber&login=501%40mix&domain=mix.nms.mixnetworks.net&user=501&type=vmail&file=vm-20130109213243000082_mixnetworks_net.wav&time=20130110170638&auth=c43ff32546e126be9b895bbf225b2e75&submit=PLAY");
                 AudioInputStream fis =
                  AudioSystem.getAudioInputStream(url);
                 System.out.println("File AudioFormat: " + fis.getFormat());
                 AudioInputStream ais = AudioSystem.getAudioInputStream(
                  AudioFormat.Encoding.PCM_SIGNED,fis);
                 AudioFormat af = ais.getFormat();
                 System.out.println("AudioFormat: " + af.toString());

                 int frameRate = (int)af.getFrameRate();
                 System.out.println("Frame Rate: " + frameRate);
                 int frameSize = af.getFrameSize();
                 System.out.println("Frame Size: " + frameSize);

                 SourceDataLine line = AudioSystem.getSourceDataLine(af);
                 line.addLineListener(new MyLineListener());

                 line.open(af);
                 int bufSize = line.getBufferSize();
                 System.out.println("Buffer Size: " + bufSize);

                 line.start();

                 byte[] data = new byte[bufSize];
                 int bytesRead;

                 while ((bytesRead = ais.read(data,0,data.length)) != -1)
                     line.write(data,0,bytesRead);

                 line.drain();
                 line.stop();
                 line.close();