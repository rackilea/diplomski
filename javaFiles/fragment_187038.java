public static Uri getVideoContentUriFromFilePath(Context context, File fileToShare) {
    String filePath = fileToShare.getAbsolutePath();
    Cursor cursor = context.getContentResolver().query(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            new String[] { MediaStore.Video.Media._ID },
            MediaStore.Video.Media.DATA + "=? ",
            new String[] { filePath }, null);
    if (cursor != null && cursor.moveToFirst()) {
        int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
        return Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "" + id);
    } else {
        if (fileToShare.exists()) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Video.Media.DATA, filePath);
            return context.getContentResolver().insert(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
        } else {
            return null;
        }
    }
}