ArrayList<HashMap<String, String>> songsList = new ArrayList<>();
String[] STAR = {"*"};

Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
Cursor cursor = managedQuery(uri, STAR, selection, null, null);

if (cursor != null) {
    if (cursor.moveToFirst()) {
        do {
            String songName = cursor.getString(cursor.
                    getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
            String path = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DATA));
            String albumName = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.ALBUM));
            int albumId = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));

            HashMap<String, String> song = new HashMap<String, String>();
            song.put("songTitle", albumName + " " + songName + "___" + albumId);
            song.put("songPath", path);
            songsList.add(song);
        } while (cursor.moveToNext());
    }
}