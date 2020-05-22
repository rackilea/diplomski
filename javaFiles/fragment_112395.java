private void playWav(String soundFilePath) {
    File sFile = new File(soundFilePath);
    if (!sFile.exists()) {
        String ls = System.lineSeparator();
        System.err.println("Can not locate the supplied sound file!" + 
                ls + "(" + soundFilePath + ")" + ls);
        return;
    }
    try {

        Clip clip;
        try (AudioInputStream audioInputStream = AudioSystem.
                getAudioInputStream(sFile.getAbsoluteFile())) {
            clip = AudioSystem.getClip();
            // Rewind clip to beginning. 
            // Not really required in this example!
            // It's just good to know.
            clip.setFramePosition(0); 
            clip.open(audioInputStream);
        }
        clip.start();
    }
    catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        Logger.getLogger("playWav()").log(Level.SEVERE, null, ex);
    }
}