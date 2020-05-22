@Override
public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
    final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
    if (width > height) {
        setMeasuredDimension(height, height);
    } else {
        setMeasuredDimension(width, width);
    }


    Log.v(TAG, "sizes are h: " + height + " w: " + width);
}


@Override
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    /**
     * Changed Size of TextView from "width" x "height" to "width" x "width"
     * to look like square*/
    super.onSizeChanged(w, w, oldw, oldh);

    /**
     * Hack -
     * if height is bigger then width
     * set height size to width
     * if width is bigger than height then
     * set width size to height
     */
    Log.v(TAG, "sizes2 are h: " + h + " w: " + w);
    if (getLayoutParams() != null && w < h) {
        getLayoutParams().height = w;
        setLayoutParams(getLayoutParams());
    }
    else if(getLayoutParams() != null && w > h){
        getLayoutParams().width = h;
        setLayoutParams(getLayoutParams());
    }
}