Runnable pressRunnable = new Runnable() {
    @Override
    public void run() {
        button.setPressed(true);
        button.postOnAnimationDelayed(unpressRunnable, 250);
    }
};

Runnable unpressRunnable = new Runnable() {
    @Override
    public void run() {
        button.setPressed(false);
        button.postOnAnimationDelayed(pressRunnable, 250);
    }
};