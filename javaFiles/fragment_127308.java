Bitmap bitmapOrg = ((Main) parentActivity).mPhoto;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // compress bitmap into the byte array output stream
    bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 75, baos);
    // form byte array out of byte array output stream
    byte[] ba = baos.toByteArray();
    String encodedImage = Base64.encodeBytes(ba);
    HttpClient httpclient = new DefaultHttpClient();