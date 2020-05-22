Clip clip4 = null; // Make this a member variable.
...
if (message.equals("rock1")) {
  AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("D:/Andrd/Music/TheAll-AmericanRejects-Swing,Swing.wav"));
  clip4 = AudioSystem.getClip();
  clip4.open(inputStream);
  clip4.start();
} else if (message.equals("stop") && clip4 != null && clip4.isRunning())
  clip4.stop();
}