audioLineClip.addLineListener(new LineListener() {
    @Override
    public void update(LineEvent event) {
        ... listen when audio is ended and close the line. to end the program.
    }
});