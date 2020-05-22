public static void playSong(File songFile) {
    AudioInputStream audioInput;
    try {
        audioInput = AudioSystem.getAudioInputStream(songFile);
        //Deleted this line:
        //Clip clip;
        //This line has been updated:
        this.clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
    } catch (Exception e) {
    }
}