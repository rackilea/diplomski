public void run() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("NameOfFile.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY); // There are several different amounts of time you can loop it, so you can change this if you want, or you can just use clip.stop() whenever you want.
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}