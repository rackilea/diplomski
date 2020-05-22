public static List<String> getCameraImages(Context context) {
    public final String CAMERA_IMAGE_BUCKET_NAME = Environment.getExternalStorageDirectory().toString()+ "/DCIM/Camera";

    public final String CAMERA_IMAGE_BUCKET_ID = String.valueOf(CAMERA_IMAGE_BUCKET_NAME.toLowerCase().hashCode());

    final String[] projection = { MediaStore.Images.Media.DATA };
    final String selection = MediaStore.Images.Media.BUCKET_ID + " = ?";
    final String[] selectionArgs = { CAMERA_IMAGE_BUCKET_ID };
    final Cursor cursor = context.getContentResolver().query(Images.Media.EXTERNAL_CONTENT_URI, 
        projection, 
        selection, 
        selectionArgs, 
        null);
    ArrayList<String> result = new ArrayList<String>(cursor.getCount());
    if (cursor.moveToFirst()) {
        final int dataColumn = 
cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        do {
            final String data = cursor.getString(dataColumn);
            result.add(data);
        } while (cursor.moveToNext());
    }
    cursor.close();
    return result;
}