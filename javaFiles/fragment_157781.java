String[] proj = {
    MediaStore.Video.Media._ID,
        MediaStore.Video.Media.DISPLAY_NAME,
    MediaStore.Video.Media.DATA
};

Cursor cursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, 
                                    proj, MediaStore.Video.Media.DISPLAY_NAME+"=?",new String[] {"name.mp4"}, null);
cursor.moveToFirst()
id = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media._ID));