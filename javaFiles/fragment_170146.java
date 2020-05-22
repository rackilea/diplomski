public void draw(final Canvas canvas) {
    canvas.drawRect(tileRect, squareColor); // Draws background no matter if place is empty.
    if(pieceDrawable != null) {
        Bitmap image = ((BitmapDrawable) pieceDrawable).getBitmap();
        ColorFilter filter = new LightingColorFilter(squareColor.getColor(), Color.TRANSPARENT);
        squareColor.setColorFilter(filter);
        canvas.drawBitmap(image, null, tileRect, squareColor);
    }
}