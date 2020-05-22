try{ 
    URL soundURL = getClass().getResource(filePath); 
    AudioInputStream AIS = AudioSystem.getAudioInputStream(soundURL); 
    Clip clip = AudioSystem.getClip(); 
    clip.open(AIS);
    return clip;
} catch (Exception ex) {
    ex.printStackTrace();
}