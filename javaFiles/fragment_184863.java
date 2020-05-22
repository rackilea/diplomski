private void alarm(){
    SharedPreferences getAlarms = PreferenceManager.
                                  getDefaultSharedPreferences(getBaseContext());
    String alarms = getAlarms.getString("ringtone", "default ringtone");
    Uri uri = Uri.parse(alarms);
    playSound(this, uri);

    //call mMediaPlayer.stop(); when you want the sound to stop
}


private MediaPlayer mMediaPlayer;
private void playSound(Context context, Uri alert) {
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(context, alert);
            final AudioManager audioManager = (AudioManager) context
                    .getSystemService(Context.AUDIO_SERVICE);
            if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            }
        } catch (IOException e) {
            System.out.println("OOPS");
        }
    }