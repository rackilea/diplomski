public void getAlbumsLists() {
    final Uri uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
    final String _id = MediaStore.Audio.Albums._ID;
    final String album_name = MediaStore.Audio.AlbumColumns.ALBUM;
    final String artist = MediaStore.Audio.AlbumColumns.ARTIST;
    final String tracks = android.provider.MediaStore.Audio.Albums.NUMBER_OF_SONGS;
    //final String data=MediaStore.Audio.Media.DATA; // NO
    final String id1=MediaStore.Audio.Albums._ID;
    final String tit=MediaStore.Audio.Albums.ALBUM; //NO
    final String nam=MediaStore.Audio.Albums.ALBUM_KEY; // NO
    final String typ=MediaStore.Audio.Media.MIME_TYPE; // NO
    final String art=MediaStore.Audio.Albums.ALBUM_ART; //<<<< CAN GET
    final String artstkey = MediaStore.Audio.Artists.ARTIST_KEY; //<<<< CAN GET
    final String frstyr = MediaStore.Audio.AlbumColumns.FIRST_YEAR; //<<<< CAN GET
    final String lstyr = MediaStore.Audio.AlbumColumns.LAST_YEAR; //<<<< CAN GET
    final String artstid = "artist_id"; //<<<< CAN GET

    final String[] columns = {"*"};

    Cursor cursor = this.getContentResolver().query(uri, columns,null, null, null);
    // Lists the columns in the cursor
    for (String s :cursor.getColumnNames()
         ) {
        Log.d("COLUMNS","Column = " +s);
    }
    while (cursor.moveToNext()) {
        String id = (cursor.getString(cursor.getColumnIndex(_id)));
        String name = cursor.getString(cursor.getColumnIndex(album_name));
        String artist2 = cursor.getString(cursor.getColumnIndex(artist));
        String nr = cursor.getString(cursor.getColumnIndex(tracks));
        //String data1=cursor.getString(cursor.getColumnIndexOrThrow(data)); //<<<< NOT A COLUMN
        String id2=cursor.getString(cursor.getColumnIndex(id1));
        //String title=cursor.getString(cursor.getColumnIndex(tit)); //<<<< NOT A COLUMN
        //String name1=cursor.getString(cursor.getColumnIndex(nam)); //<<<< NOT A COLUMN
        //String type=cursor.getString(cursor.getColumnIndex(typ)); //<<<< NOT A COLUMN
        // AVAIALABLE COLUMNS
        String artwork = cursor.getString(cursor.getColumnIndex(art)); //<<<< ADDED
        String artistkey = cursor.getString(cursor.getColumnIndex(artstkey)); //<<<< ADDED
        String artistid = cursor.getString(cursor.getColumnIndex(artstid)); //<<<< ADDED
        String minyear = cursor.getString(cursor.getColumnIndex(frstyr));
        String maxyear = cursor.getString(cursor.getColumnIndex(lstyr));
        albumInfo s = new albumInfo(id, name, artist2, nr,data,id2,title,name1,type); // EXCLUDED

            albumList.add(s); // EXCLUDED
        }
    cursor.close();
    recyclerView1.setAdapter(albumAdapter); // EXCLUDED
}