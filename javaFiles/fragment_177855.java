view.setDrawingCacheEnabled(true);
viewCapture = Bitmap.createBitmap(view.getDrawingCache());
view.setDrawingCacheEnabled(false);
//Source Rect sized to the surface view.
Rect src = new Rect(0, 0, viewCapture.getWidth(), viewCapture.getHeight());
//Destination RectF sized to the camera picture
RectF dst = new RectF(0, 0, myImage.getWidth(), myImage.getHeight());
canvas.drawBitmap(viewCapture, src, dst, paint);