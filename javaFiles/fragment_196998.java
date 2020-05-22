private Clip clip;

public void playsound(File sound) {
    try {
        if (clip == null) {
            clip = AudioSystem.getClip();
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });
        }
        // Is the clip active or running?
        if (!clip.isActive() && !clip.isRunning()) {
            if (clip.isOpen()) {
                clip.close();
            }
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}