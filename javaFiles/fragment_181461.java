protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    int height = MeasureSpec.getSize(heightMeasureSpec);

    int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");

    int statusBarHeight = 0;
    if (resourceId > 0) {

         statusBarHeight = getResources().getDimensionPixelSize(resourceId);
    }

    dm = getResources().getDisplayMetrics();

    int screenHeight = dm.heightPixels;
    int diff = (screenHeight - statusBarHeight) - height;
    if(mListener != null){
        mListener.onSoftKeyboardShown(diff);
    }
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
}