private void drawer(Canvas canvas) {

        Bitmap bitmapOriginal = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        Bitmap bitmapNew = Bitmap.createBitmap(bitmapOriginal.getWidth(), bitmapOriginal.getHeight(), Config.ARGB_8888);
        bitmapNew.eraseColor(Color.WHITE); // color that You want to set

        canvas.drawBitmap(bitmapNew, 0, 0, null);
        canvas.drawBitmap(bitmapOriginal, 0, 0, null);

    }