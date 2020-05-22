videoFrame.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
// YOUR CODE GOES HERE
videoFrame.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
});