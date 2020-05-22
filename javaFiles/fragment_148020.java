public static String bitmapToBase64(Bitmap bitmap) {
        byte[] bitmapdata = bitmapToByteArray(bitmap);
        return Base64.encodeBytes(bitmapdata);
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 0 /* ignored for PNG */, bos);
        byte[] bitmapdata = bos.toByteArray();
        return bitmapdata;
    }