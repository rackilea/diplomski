String[] projection = new String[] {
    MediaStore.Audio.Media.ALBUM,
    MediaStore.Audio.Media.ARTIST,
    MediaStore.Audio.Media.TITLE
};

Cursor cursor = managedQuery(
    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, //URI
    projection, //columns to return
    null, //rows to return -  all
    null, //selection arguments - none
    null // sort order - default
);

cursor.moveToFirst();

while(! cursor.isLast()) {
    Log.d("MediaTest","Found track:");
    Log.d("MediaTest","Album " + cursor.getString(0));
    Log.d("MediaTest","Artist " + cursor.getString(1));
    Log.d("MediaTest","Track " + cursor.getString(2));
    cursor.moveToNext();
}