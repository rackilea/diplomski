ExifInterface ex = new ExifInterface(uri.getPath());
    int rotation = ex.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
    Boolean needsRotation = (rotation != ExifInterface.ORIENTATION_NORMAL));
    if (needsRotation) {
        imageView.setRotation(180f);
    } else {
        imageView.setRotation(0f);
    }