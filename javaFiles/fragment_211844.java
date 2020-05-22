boolean isPlaying = false;

private void buttonMouseClicked() {
    if (isPlaying) return;
    isPlaying = true;

    AudioInputStream audio;
    try {
        audio = AudioSystem.getAudioInputStream(getClass().getResource("/AppPackage/BH/chr.wav"));
        Clip clip;
        clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
    } catch (UnsupportedAudioFileException ex) {
        ex.printStackTrace();
    } catch (LineUnavailableException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }        
}