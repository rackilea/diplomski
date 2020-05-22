ViewTreeObserver vto = currentMode.getViewTreeObserver();
vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        if(currentMode.isShown()) {
            YoYo.with(Techniques.SlideInDown).duration(250).playOn(currentMode);
        }
    }
});
currentMode.setVisibility(mShouldShowMode ? View.VISIBLE : View.GONE);