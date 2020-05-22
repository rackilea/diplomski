try
 {
   Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
   File file = new File(path + "/sample/loop1.wav");

   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

   AudioFormat format = audioInputStream.getFormat();

   long audioFileLength = file.length();
   int frameSize = format.getFrameSize();
   float frameRate = format.getFrameRate();
   float durationInSeconds = (audioFileLength / (frameSize * frameRate));
 }
catch (UnsupportedAudioFileException | IOException ex)
 {
   ex.printStackTrace();
 }