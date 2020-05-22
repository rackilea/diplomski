class TransitionScreen extends Screen {
    private int transitionOffset;
    private boolean isTransitionHorizontal;
    private ScreenTransition currentTransition;

    public TransitionScreen(boolean isTransitionHorizontal) {
        this.isTransitionHorizontal = isTransitionHorizontal;

        transitionOffset = getTransitionMaximum(); // So the screen starts offset
    }

    protected void paint(Graphics graphics) {
        // use transitionOffset as x or y depending on isTransitionHorizontal
        graphics.pushContext(...);
    }

    protected void onExposed() {
        transitionToOffset(0);
    }

    protected void onObscured() {
        int target = getTransitionMaximum();

        transitionToOffset(target);
    }

    private int getTransitionMaximum() {
        return isTransitionHorizontal ? Display.getWidth() : Display.getHeight();
    }

    private void transitionToOffset(int target) {
        if (currentTransition != null) {
            currentTransition.stop();
        }

        currentTransition = new ScreenTransition(target);

        getApplication().invokeLater(currentTransition);
    }
}

class ScreenTransition implements Runnable {
    private boolean animating;
    private int target;

    public ScreenTransitionUpdater(int target) {
        this.target = target;
    }

    public void stop() {
        animating = false;
    }

    public void run() {
        while(animating) {
            Object eventLock = getApplication().getEventLock();

            synchronized(eventLock) {
                // Interpolate myOffset to target

                // Set animating = false if myOffset = target

                invalidate();
            }
        }
    }
}