try {
        while (cursor.moveToNext()) {
            songTitle = cursor.getString(1);
            songArtist = cursor.getString(2);
            songYear = cursor.getString(4);
            Log.i(TAG, String.valueOf(songTitle));
        }
    } finally {
        cursor.close()
    }