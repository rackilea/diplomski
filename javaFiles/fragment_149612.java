Map<String, Clip> clips = new HashMap<String, Clip>();

public synchronized void play(String url) {
    Clip clip = clips.get(url);
    if(clip == null) {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
            TheGame.class.getResource(url));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clips.put(url, clip);
    }
    if(clip.isRunning())
        clip.stop();
    clip.setFramePosition(0);
    clip.start(); 
}