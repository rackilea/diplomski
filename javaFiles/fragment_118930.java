int w = rootLayout.getWidth();
int h = rootLayout.getHeight();

// or if view haven't been laid out yet:
rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        rootLayout.getViewTreeObserver()
                .removeOnGlobalLayoutListener(this);

        int w = rootLayout.getWidth();
        int h = rootLayout.getHeight();
    }
});