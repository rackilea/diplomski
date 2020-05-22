final Clip clip = AudioSystem.getClip();
clip.addLineListener(new LineListener() {
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP)
            clip.close();
    }
});