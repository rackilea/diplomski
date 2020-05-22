public void drawFixedText(String text, Rect rect, Paint paint) {
    paint.setAntiAlias(true);
    paint.setStyle(Paint.Style.FILL);

    float textSize = paint.getTextSize();
    float textWidth = paint.measureText(text);

    while (textWidth > rect.width())  {
        textSize--;
        paint.setTextSize(textSize);
        textWidth = paint.measureText(text);
    }

    Rect bounds = new Rect();
    paint.getTextBounds(text, 0, text.length(), bounds);

    canvas.drawText(text,
                    rect.centerX() - textWidth / 2,
                    rect.centerY() - (bounds.top + bounds.bottom) / 2,
                    paint);
}