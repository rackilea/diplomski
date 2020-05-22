private String getRealPathFromUri(Uri contentURI) {
    String result = "";
    Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
    if (cursor == null) {
        result = contentURI.getPath();
    } else {
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        result = cursor.getString(idx);
        cursor.close();
    }
    return result;
}