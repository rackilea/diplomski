// other draw methods, including a bitmap, ovals from float[]-Arrays, paths and text

Paint paint = new Paint();
paint.setColor(0x33d0d5c9);
paint.setStyle(Paint.Style.FILL);
paint.setFlags(Paint.ANTI_ALIAS_FLAG);

RectF rect = new RectF();
for(int i = 0; i < 200) {
    rect.set(x1, y1, x2, y2);
    canvas.drawOval(rect, paint);
}