private class MotionEntry {
    private final View view;
    private final MotionEvent event;

    public MotionEntry(View view, MotionEvent event) {
        this.view = view;
        this.event = event;
    }
}