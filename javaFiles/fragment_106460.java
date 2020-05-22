public static Bitmap mergeToPin(Bitmap back, Bitmap front) {
    Bitmap result = Bitmap.createBitmap(back.getWidth(), back.getHeight(), back.getConfig());
    Canvas canvas = new Canvas(result);
    int widthBack = back.getWidth();
    int widthFront = front.getWidth();
    float move = (widthBack - widthFront) / 2;
    canvas.drawBitmap(back, 0f, 0f, null);
    canvas.drawBitmap(front, move, move, null);
    return result;
}