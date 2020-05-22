File afile = new File(audioFilePath);
AudioInputStream astream = AudioSystem.getAudioInputStream(afile);
Clip audio = AudioSystem.getClip();
audio.open(astream);
audio.setFramePosition(0);
audio.start();