Uri mediaContentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    String[] projection = new String[] { MediaStore.Audio.Media._ID, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ALBUM_ID};
    String selection = MediaStore.Audio.Media._ID + "=?";
    String[] selectionArgs = new String[] {"" + id}; //This is the id you are looking for

    Cursor mediaCursor = getContentResolver().query(mediaContentUri, projection, selection, selectionArgs, null);

    if(mediaCursor.getCount() >= 0) {
        mediaCursor.moveToPosition(0);
        String title = mediaCursor.getString(mediaCursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
        String album = mediaCursor.getString(mediaCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
        String artist = mediaCursor.getString(mediaCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
        long duration = mediaCursor.getLong(mediaCursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

        //Do something with the data
    }