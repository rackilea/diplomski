private void setup() {
    /* the song has been select setup the interface */
    /* displays song name in title */
    TextView titleView = (TextView) findViewById(R.id.song_appbar_title);
    String songName;

    ContentResolver contentResolver = this.getContentResolver();
    Cursor cursor = contentResolver.query(song, null, null, null, null);

    if (cursor != null && cursor.moveToFirst()) {
        songName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
        titleView.setText(songName);
    }


    /* removes the notSelected String */
    selectSong.setVisibility(View.GONE);

    /* setup media player */
    mediaPlayer = new MediaPlayer();
    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    try {
        mediaPlayer.setDataSource(getApplicationContext(), song);
        mediaPlayer.prepareAsync();
    } catch (IOException e) {
        Toast.makeText(this, "file not found", Toast.LENGTH_SHORT).show();
    }

    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
        /* show media player layout */
            seekBar.setMax(mediaPlayer.getDuration());

            RelativeLayout mpl = (RelativeLayout) findViewById(R.id.media_player_layout);
            mpl.setVisibility(View.VISIBLE);
            mediaPlayer.start();

            updateSeekBar();


            ImageButton pb = (ImageButton) findViewById(R.id.song_play_button);
            pb.setImageResource(R.drawable.pause);

        }
    });

    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            ImageButton pb = (ImageButton) findViewById(R.id.song_play_button);
            pb.setImageResource(R.drawable.ic_play_arrow_white_24dp);
        }
    });

}