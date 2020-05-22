public int getTextWidth(String text, Paint paint) {
    Rect bounds = new Rect();
    paint.getTextBounds(text, 0, text.length(), bounds);
    int width = bounds.left + bounds.width();
    return width;
}

public int getTextHeight(String text, Paint paint) {
    Rect bounds = new Rect();
    paint.getTextBounds(text, 0, text.length(), bounds);
    int height = bounds.bottom + bounds.height();
    return height;
}