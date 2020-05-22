public static String addTracksToPlaylist(final long id, List<MediaData> tracks, final Context context) {
    int count = getPlaylistSize(id, context);
    ContentValues[] values = new ContentValues[tracks.size()];
    for (int i = 0; i < tracks.size(); i++) {
        values[i] = new ContentValues();
        values[i].put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, i + count + 1);
        values[i].put(MediaStore.Audio.Playlists.Members.AUDIO_ID, tracks.get(i).getId());
    }
    Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external", id);
    ContentResolver resolver = context.getContentResolver();
    int num = resolver.bulkInsert(uri, values);
    resolver.notifyChange(Uri.parse("content://media"), null);
    return String.format(context.getString(R.string.ADDED_TO_PLAYLIST), num, context.getString(R.string.CURRENT));
 }