public static String convertToBase64(String path) {
        Bitmap bm = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] byteArrayImage = baos.toByteArray();
        String encodedImage = android.util.Base64.encodeToString(byteArrayImage, android.util.Base64.DEFAULT);
        return encodedImage;
    }


    public static Bitmap decodeFromBase64ToBitmap(String encodedImage) {

        byte[] decodedString = android.util.Base64.decode(encodedImage, android.util.Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }