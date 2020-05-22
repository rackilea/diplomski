public static void playSound(File soundfile)  throws LineUnavailableException, UnsupportedAudioFileException, IOException{
        AudioInputStream audioInputStream = null;
        audioInputStream = AudioSystem.getAudioInputStream(soundfile);              
        Clip clip = AudioSystem.getClip();              
        clip.open(audioInputStream);
        clip.start();
}