final Button btn = new Button("Click me!");
btn.setOnMousePressed((event) -> {
    /**
     * Check if this is the first time this handler runs.
     * - If so, start a timer that runs every 0.5 seconds.
     * - If not, do nothing. The timer is already running.
     */
});
btn.setOnMouseReleased((event) -> {
    //Stop the timer.
});