Bitmap filter,  // the filter
        original, // our original
        tempBitmap; // the bitmap which holds the canvas results 
                    // and is then drawn to the imageView
    Canvas mCanvas; // our canvas

    int x = 0;   // The x coordinate of the filter. This variable will be manipulated
                        // in either onFling or onScroll.
    void draw() {
        // clear canvas
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);    

        // setup paint
        paint0.setAlpha(255);   // the original needs to be fully visible
        paint1.setAlpha(128);   // the filter should be alpha blended into the original.

        // enable AA for paint
        // filter image
        paint1.setAntiAlias(true);
        paint1.setFlags(Paint.ANTI_ALIAS_FLAG);     // Apply AA to the image. Optional.
        paint1.setFlags(Paint.FILTER_BITMAP_FLAG);  // In case you scale your image, apple
                                                    // bilinear filtering. Optional.
        // original image
        paint0.setAntiAlias(true);
        paint0.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint0.setFlags(Paint.FILTER_BITMAP_FLAG);

        // draw onto the canvas    
        mCanvas.save();                

        mCanvas.drawBitmap(original, 0,0,paint0);
        mCanvas.drawBitmap(filter, x,0,paint1);    

        mCanvas.restore();

        // set the new image
        imageView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
    }