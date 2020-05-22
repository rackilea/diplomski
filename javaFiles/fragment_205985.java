try{
        byte[] decodedByte = Base64.decode(input, 0);
        InputStream stream = new ByteArrayInputStream(decodedByte);
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        return bitmap;
    }
    catch (Exception e) {
        return null;
    }