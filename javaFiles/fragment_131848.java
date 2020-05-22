new Handler(Looper.getMainLooper()).post(new Runnable() {
    @Override
    public void run() {
        // do UI work
        yourview.requestLayout();
    }
});