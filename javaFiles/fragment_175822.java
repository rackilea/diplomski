cursor = this.ctx.query(uri, new String[]{Playlists.Members.AUDIO_ID}, null, null, null);

if(cursor != null && cursor.getCount() > 0) {
    this.numSongs = cursor.getCount();
    Log.d(TAG, "numSongs: "+this.numSongs); // Correctly outputs 3

    int randomNum = (int)(Math.random() * this.numSongs);
    if(cursor.moveToPosition(randomNum)) {
        int idColumn = cursor.getColumnIndex(Playlists.Members.AUDIO_ID); // This doesn't seem to be giving me a track from the playlist
        // or just cursor.getLong(0) since it's the first and only column you request
        this.currentSongId = cursor.getLong(idColumn);
        try {
            JSONObject song = this.getSongInfo();
            play(); // This plays whatever song id is in "this.currentSongId"
            result = new PluginResult(Status.OK, song);
        } catch (Exception e) {
            result = new PluginResult(Status.ERROR);
        }
    }
}