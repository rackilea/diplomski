File fileSong = new File (filePath);
  AudioInputStream input = AudioSystem.getAudioInputStream(fileSong); 
  clip = AudioSystem.getClip(); 
  clip.open(input); 
  clip.setMicrosecondPosition(position); 

  FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); 
  float range = (float) (Math.log(userInput) / Math.log(10) * 20); 
  gainControl.setValue(range); 
  clip.start();