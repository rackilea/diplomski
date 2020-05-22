public void playSound(int i) {
  try {
     // ...
     if (i == 3 || i == 4) {
        if (i == 3) {
           audioInputStream = AudioSystem
                 .getAudioInputStream(new File("Background.wav"));
           clip3 = AudioSystem.getClip();
           clip3.open(audioInputStream);
           clip3.loop(Clip.LOOP_CONTINUOUSLY);
           clip3.start();
           settingSubMenuItem3.setEnabled(false);
           settingSubMenuItem4.setEnabled(true);
        }
        if (i == 4) {
           if (clip3 != null && clip3.isActive()) {
              clip3.stop();
              settingSubMenuItem3.setEnabled(true);
              settingSubMenuItem4.setEnabled(false);
           }
        }
     }
  } catch (Exception e) {
     System.out.println("Error with playing sound.");
     e.printStackTrace();
  }
}