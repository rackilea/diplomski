@Override
protected void onDraw(Canvas c) {

if(bitmap != null && canvas != null) { 
    canvas.drawLine(p1.x, p1.y, p2.x, p2.y, linePaint);
    c.drawBitmap(bitmap, 0, 0, linePaint);  
}
}

@Override
public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

bitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
canvas = new Canvas(bitmap);
canvas.drawColor(Color.WHITE);
}