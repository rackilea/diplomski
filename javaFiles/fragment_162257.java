final View activityRootView = findViewById(R.id.activityRoot);
activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
        if (heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
            ... do something here
        }
     }
});