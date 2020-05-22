public Bitmap blur(int resourceId) {
        final Bitmap normalOne = BitmapFactory.decodeResource(getResources(),resourceId);
        final Bitmap resultBitmap = Bitmap.createBitmap(normalOne.getWidth(), normalOne.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        mPaint.setAlpha(180);
        canvas.drawBitmap(normalOne, 0, 0, mPaint);
        int blurRadius = 12;
        for (int row = -blurRadius; row < blurRadius; row += 2) {
            for (int col = -blurRadius; col < blurRadius; col += 2) {
                if (col * col + row * row <= blurRadius * blurRadius) {
                    mPaint.setAlpha((blurRadius * blurRadius) / ((col * col + row * row) + 1) * 2);
                    canvas.drawBitmap(normalOne, row, col, mPaint);
                }
            }
        }
        normalOne.recycle();
        return resultBitmap;
    }