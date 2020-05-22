public static Cursor getTrackListFromPlaylist(Context context, long plid) {
        String[] MEDIA_COLUMNS = new String[] {
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ARTIST_ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Playlists.Members.AUDIO_ID,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MINUTES + "||':'||" + SECONDS + " as " + FORMATTED_DURATION,
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media._ID
        };
        return query(context, MediaStore.Audio.Playlists.Members.getContentUri("external", plid),
                MEDIA_COLUMNS, null, null, MediaStore.Audio.Playlists.Members.DEFAULT_SORT_ORDER);
    }