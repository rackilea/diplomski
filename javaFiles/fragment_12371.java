private boolean isCorrectConnection(float startX, float startY, float endX, float endY,
                                   float x1, float y1, float x2, float y2
                                   String text) {
    //Measuring text's size
    Rect textBounds = new Rect();
    mPaint.getTextBounds(text, 0, text.length(), textBounds);
    int w1 = textBounds.width(), w2 = w1;
    int h1 = textBounds.height(), h2 = h1;

    //Checking for touched and moved from text1 to text2
    if(startX >= x1 && startX <= (x1 + w1) && startY >= y1 && startY <= (y1 + h1) &&
       endX >= x2 && endX <= (x2 + w2) && endY >= y2 && endY <= (y2 + h2))
        return true;

    //Checking for touched and moved from text2 to text1
    if(startX >= x2 && startX <= (x2 + w2) && startY >= y2 && startY <= (y2 + h2) &&
       endX >= x1 && endX <= (x1 + w1) && endY >= y1 && endY <= (y1 + h1))
        return true;

    return false;
}