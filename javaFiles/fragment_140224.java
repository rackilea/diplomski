intent.putExtra("myImage", convertBitmapToByteArray(bitmapImage));

byte[] convertBitmapToByteArray(Bitmap bitmap) {
    ByteArrayOutputStream baos = null;
    try {
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    } finally {
        if (baos != null) {
            try {
                baos.close();
            } catch (IOException e) {
                Log.e(BitmapUtils.class.getSimpleName(), "ByteArrayOutputStream was not closed");
            }
        }
    }
}