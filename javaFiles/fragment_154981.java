newsContainer.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        // title.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // date.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // background.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        RelativeLayout.LayoutParams paramsTitle = (RelativeLayout.LayoutParams) title.getLayoutParams();
        // paramsTitle.width = background.getMeasuredWidth() - date.getMeasuredWidth();
        paramsTitle.width = background.getWidth() - date.getWidth();
        title.setLayoutParams(paramsTitle);
        title.requestLayout();
    }
});