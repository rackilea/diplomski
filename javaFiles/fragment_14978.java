public Bitmap drawTextToBitmap(Bitmap bitmap,  String mText) {
    try {

        android.graphics.Bitmap.Config bitmapConfig =   bitmap.getConfig();
        // set default bitmap config if none
        if(bitmapConfig == null) {
          bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        }
        // resource bitmaps are imutable,
        // so we need to convert it to mutable one
        bitmap = bitmap.copy(bitmapConfig, true);

        Canvas canvas = new Canvas(bitmap);
        // new antialised Paint
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // text color - #3D3D3D
        paint.setColor(Color.rgb(110,110, 110));
        // text size in pixels
        paint.setTextSize((int) (12 * scale));
        // text shadow
        paint.setShadowLayer(1f, 0f, 1f, Color.DKGRAY);

        // draw text to the Canvas center
        Rect bounds = new Rect();
        paint.getTextBounds(mText, 0, mText.length(), bounds);
        int x = (bitmap.getWidth() - bounds.width())/6;
        int y = (bitmap.getHeight() + bounds.height())/5;

        canvas.drawText(mText, x * scale, y * scale, paint);

        return bitmap;
    } catch (Exception e) {
        return null;
    }

  }