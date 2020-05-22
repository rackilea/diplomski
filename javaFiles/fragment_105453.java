public void resizeText(float width, float currentSize, float currentWidth){
    //currentWidth/currentSize = width/x
    a = width * currentSize;//450 * 3 in example above
    b = a/currentWidth;
    return b;//returns the x or the new size that your text should be
}