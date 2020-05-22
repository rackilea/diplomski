/**
 * IMPORTANT NOTE!!!!!!!!!!!!!!
 * String is first converted to byte array, then compressed using GZIP and then
 * the resulting byte array is encoded to Base64.DEFAULT
 * @return
 */
public String getProfilePhotoBase64() {
    return mProfilePhotoBase64;
}

public Bitmap getProfilePicture(){
    if(getProfilePhotoBase64() != null) {
        byte[] decoded = Base64.decode(mProfilePhotoBase64.getBytes(), Base64.DEFAULT);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ByteArrayInputStream bis = new ByteArrayInputStream(decoded);

        GZIPInputStream zis = null;
        try {
            zis = new GZIPInputStream(bis);
            byte[] tmpBuffer = new byte[256];
            int n;
            while ((n = zis.read(tmpBuffer)) >= 0) {
                bos.write(tmpBuffer, 0, n);
            }
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeByteArray(bos.toByteArray(), 0
                , bos.toByteArray().length);

        if(bitmap != null) {
            return bitmap;
        } else {
            return null;
        }
    }
    return null;
}