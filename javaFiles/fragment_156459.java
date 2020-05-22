protected void applyTransformation(float interpolatedTime, Transformation t) {
    int newOffset;
    if(expanded) {
        newOffset = 0;
        newOffset = (int)(endOffset*(1-interpolatedTime));
    } else {
        newOffset = (int)(endOffset*(interpolatedTime));
    }
    view.scrollTo(-newOffset, 0);
}