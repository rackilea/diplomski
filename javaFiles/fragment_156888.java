byte[] imageBytes = getBlob(cursor, "ImageFieldName", null);
if (imageBytes != null)
{
     Bitmap bmp= convertByteArrayToBitmap(imageBytes);
     imageview1.setImageBitmap(bmp);
}

private byte[] getBlob(Cursor cursor, String colName, byte[] defaultValue) {
        try {
            int colIndex;
            if (cursor != null && (colIndex = cursor.getColumnIndex(colName)) > -1
                    && !cursor.isNull(colIndex))
                return cursor.getBlob(colIndex);
            return defaultValue;
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

private Bitmap convertByteArrayToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }