try (Cursor cursorac = new CursorClosable(context.getContentResolver().query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            new String[]{MediaStore.Images.Media.DATA},
            MediaStore.Images.Media._ID + " =? ",
            new String[]{"" + imageIdInMediaStore},
            null)) {
    Cursor cursor = cursorac.getCursor();
    if (cursor != null && cursor.getCount() > 0) {
        cursor.moveToFirst();
        return cursor.getString(0);
    } else {
        return "";
    }
} catch (Exception e) {
    return "";
}