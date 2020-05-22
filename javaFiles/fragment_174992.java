private MediaPlayer mMediaPlayer;
private boolean mIsPrepared;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mMediaPlayer = MediaPlayer.create(this, R.raw.raw1);
    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mIsPrepared = true;
        }
    });
}

@Override
protected void onResume() {
    super.onResume();

    if (mMediaPlayer != null && mIsPrepared) {
        mMediaPlayer.seekTo(0);
        mMediaPlayer.start();
    }
}

@Override
protected void onPause() {
    super.onPause();

    if(mMediaPlayer!=null && mIsPrepared){
        mMediaPlayer.pause();
    }
}