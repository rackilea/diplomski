// Create a bitmap with just the cropped area.
    Region region = new Region();
    Region clip = new Region(0, 0, fullScreenBitmap.getWidth(), fullScreenBitmap.getHeight());
    region.setPath(path, clip);
    Rect sourceBounds = region.getBounds();
    Rect destBounds =
        new Rect(CROPPED_MARGIN, CROPPED_MARGIN, sourceBounds.width() + CROPPED_MARGIN,
                 sourceBounds.height() + CROPPED_MARGIN);
    Bitmap croppedBitmap =
        Bitmap.createBitmap(sourceBounds.width() + CROPPED_MARGIN * 2,
                            sourceBounds.height() + CROPPED_MARGIN * 2, mBitmap.getConfig());
    canvas.setBitmap(croppedBitmap);
    canvas.drawBitmap(fullScreenBitmap, sourceBounds, destBounds, null);

    imageView.setImageBitmap(croppedBitmap);

    // Add as member variable.
    private static final int CROPPED_MARGIN = 100;