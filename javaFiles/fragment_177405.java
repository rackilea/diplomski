@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        Bitmap scaledImage = scaleBitmap(imageBitmap , 460, 230);
        mImageView.setImageBitmap(scaledImage);
    }
}

private Bitmap scaleBitmap(Bitmap bm, int maxWidth, int maxHeight) {
    int width = bm.getWidth();
    int height = bm.getHeight();

    if (width > height) {
        // landscape
        int ratio = width / maxWidth;
        width = maxWidth;
        height = height / ratio;
    } else if (height > width) {
        // portrait
        int ratio = height / maxHeight;
        height = maxHeight;
        width = width / ratio;
    } else {
        // square
        height = maxHeight;
        width = maxWidth;
    }

    bm = Bitmap.createScaledBitmap(bm, width, height, true);
    return bm;
}