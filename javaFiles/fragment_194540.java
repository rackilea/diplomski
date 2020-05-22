Cursor cursor = getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                    null);

   if(cursor.moveToFirst())
{
                for(int j=0;j<cursor.getCount();j++)
                {


                            int ALBUM_ID =  cursor.getInt((cursor
                                    .getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM_ID)));
                            String album_url = null;

                            Uri sArtworkUri = Uri
                                    .parse("content://media/external/audio/albumart");
                            Uri uri = ContentUris.withAppendedId(sArtworkUri, ALBUM_ID);
                            album_url = uri.toString();
                            ContentResolver res = this.getContentResolver();
                            // Album
                            String album_name = cursor.getString(cursor
                                    .getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM));

                            String year = cursor.getString(cursor
                                    .getColumnIndex(MediaStore.Audio.AudioColumns.YEAR));
    //                  String year = cursor.getString(cursor
    //                              .getColumnIndex(MediaStore.Audio.AlbumColumns.NUMBER_OF_SONGS));


                            // artist
                            String artist_name = cursor.getString(cursor
                                    .getColumnIndex(MediaStore.Audio.ArtistColumns.ARTIST));
                            // displayname
                            String DisplayName = cursor.getString(cursor
                                    .getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME));

// title

String Title = cursor.getString(cursor
                                    .getColumnIndex(MediaStore.MediaColumns.TITLE));
}