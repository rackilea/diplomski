public void getSongsPerAlbum(String AlbumId) {
    final Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    final String track_id = MediaStore.Audio.Media._ID;
    final String track_no = MediaStore.Audio.Media.TRACK;
    final String track_name = MediaStore.Audio.Media.TITLE;
    final String artist = MediaStore.Audio.Media.ARTIST;
    final String duration = MediaStore.Audio.Media.DURATION;
    final String album = MediaStore.Audio.Media.ALBUM;
    final String albumid = MediaStore.Audio.Media.ALBUM_ID;
    final String composer = MediaStore.Audio.Media.COMPOSER;
    final String year = MediaStore.Audio.Media.YEAR;
    final String path = MediaStore.Audio.Media.DATA;
    final String date_added = MediaStore.Audio.Media.DATE_ADDED;
    String[] columns = new String[]{
            track_id,
            track_no,
            track_name,
            artist,
            duration,
            album,
            albumid,
            composer,
            year,
            path,
            date_added
    };
    // Get all tracks if no album id
    Cursor csr;
    if (AlbumId == null || AlbumId.length() < 1) {
        csr = this.getContentResolver().query(uri, columns,null,null,track_no);
    } else {
        // Doesn't work think media has to be scanned first before albums are generated
        csr = this.getContentResolver().query(uri, columns,album + "=?",new String[]{AlbumId},track_no);
    }

    for (String s: csr.getColumnNames()
         ) {
        Log.d("SONGCOLUMN","Column = " + s);
    }
    while (csr.moveToNext()) {
        Log.d("SONG","Name of Song is " + csr.getString(csr.getColumnIndex(track_name)) +
                " from Album " + csr.getString(csr.getColumnIndex(album))
        );
    }
}