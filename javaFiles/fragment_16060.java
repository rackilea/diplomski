private void createBitMap() {
        // Create a mutable bitmap
        Bitmap bitMap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);

        bitMap = bitMap.copy(bitMap.getConfig(), true);
        // Construct a canvas with the specified bitmap to draw into
        Canvas canvas = new Canvas(bitMap);
        // Create a new paint with default settings.
        Paint paint = new Paint();
        // smooths out the edges of what is being drawn
        paint.setAntiAlias(true);
        // set color
        paint.setColor(Color.BLACK);
        // set style
        paint.setStyle(Paint.Style.STROKE);
        // set stroke
        paint.setStrokeWidth(4.5f);
        // draw circle with radius 30
        canvas.drawCircle(50, 50, 30, paint);
        // set on ImageView or any other view 
        imageView.setImageBitmap(bitMap);

    }