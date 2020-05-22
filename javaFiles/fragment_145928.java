SwingUtilities.invokeLater(new Runnable() {
  public void run() {
    String filename = "/Users/seb/Documents/workspace(NormalJava)/practs/res/backgroundMusic.wav";

    InputStream in = new FileInputStream(new File(filename));
    AudioStream audioStream = new AudioStream(in);
    AudioPlayer.player.start(audioStream);

    Thread.sleep(4000);

    AudioPlayer.player.stop(audioStream);
  }
}