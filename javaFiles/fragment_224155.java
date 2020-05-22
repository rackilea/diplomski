String[] projection = {"DISTINCT " + MediaStore.Audio.Media.ALBUM_ID,
                         MediaStore.Audio.Media._ID, 
                         MediaStore.Audio.Media.TITLE, 
                         MediaStore.Audio.Media.ARTIST, 
                         MediaStore.Audio.Media.DATA, 
                         MediaStore.Audio.Media.ALBUM,
                         MediaStore.Audio.Media.IS_MUSIC};

String selection = MediaStore.Audio.Media.IS_MUSIC + 
                   "=1 ) GROUP BY (" + MediaStore.Audio.Media.ALBUM_ID;

String sort = MediaStore.Audio.Media.ALBUM + " COLLATE NOCASE ASC";

Cursor cursor = context.
                 getContentResolver().
                 query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                 projection,
                 selection,
                 null,
                 sort);