File soundFile = new File("path_to_file\\doorbell.wav");
Clip clip = AudioSystem.getClip();
AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
clip.open(inputStream);
clip.stop();//to avoid overlaps
clip.setFramePosition(0);
clip.start();