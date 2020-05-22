Bitmap bitmap = null;
MediaMetadataRetriever mediaMetadataRetriever = null;
byte[] data;

try {
    mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(url.toString(), new HashMap<String, String>());
    data = mediaMetadataRetriever.getEmbeddedPicture();
    if (data != null) {
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        }
    } catch (Exception e) {
        Log.e(TAG, " ", e);
    } finally {
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
    }
    return bitmap;
}