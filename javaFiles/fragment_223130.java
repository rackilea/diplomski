public Bitmap draWUsingRect() {
        // using rectangle
        int widthSmall = 120;
        int heightSmall = 80;
        int widthLarge = 400;
        int heightLarge = 300;
        Bitmap resultBitmap = Bitmap.createBitmap(widthLarge + 20, heightSmall + heightLarge + 20, Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(new Rect(widthSmall / 2, 0, widthSmall, heightSmall), paint);
        canvas.drawRect(new Rect(0, heightSmall, widthLarge, heightSmall + heightLarge), paint);
        return resultBitmap;
    }