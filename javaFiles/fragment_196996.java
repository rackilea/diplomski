private Set<File> playing = new HashSet<File>(25);

public void playsound(File sound) {
    try {
        // Is the been played or not?
        if (!playing.contains(sound)) {
            // And the sound to prevent it from been played again
            playing.add(sound);
            // Set up a new clip
            Clip clip = AudioSystem.getClip();
            // Monitor the clip's status, we want to know when it ends
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    // Clip has stopped
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Release the resources
                        clip.close();
                        // Remove the sound from our list
                        // so it can be played again
                        playing.remove(sound);
                    }
                }
            });
            // Play it again Sam
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        }
    } catch (Exception e) {
        // Remove the sound if something goes wrong
        playing.remove(sound);
        e.printStackTrace();
    }

}