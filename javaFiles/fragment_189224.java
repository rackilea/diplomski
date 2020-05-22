Bitmap encodeAsBitmap(String str) throws WriterException {
    BitMatrix result;

    try {
        result = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 300, 300, null);
    } catch (IllegalArgumentException iae) {
        // Unsupported format
        return null;
    }

    int w = result.getWidth();
    int h = result.getHeight();

    int[] pixels = new int[w * h];

    for (int y = 0; y < h; y++) {
        int offset = y * w;

        for (int x = 0; x < w; x++) {
            pixels[offset + x] = result.get(x, y) ? Color.BLACK : Color.WHITE;
        }
    }

    Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    bitmap.setPixels(pixels, 0, 300, 0, 0, w, h);

    return bitmap;
}