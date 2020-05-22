public Bitmap drawUsingBitmap() {
        bitmapLarge = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap_large);
        bitmapSmall = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap_small);
        Bitmap resultBitmap = Bitmap.createBitmap(bitmapLarge.getWidth(), bitmapSmall.getHeight() + bitmapLarge.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        // using bitmap
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmapSmall, bitmapSmall.getWidth() / 2, 0, paint);
        canvas.drawBitmap(bitmapLarge, 0, bitmapSmall.getHeight() - 10, paint);
        return resultBitmap;
    }