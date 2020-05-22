mPopWindowInstance.setTouchInterceptor(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            mPopWindowInstance.dismiss();
            return true;
        }
        return false;
    }
});