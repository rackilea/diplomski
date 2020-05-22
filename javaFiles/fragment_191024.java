@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

   //this line is EXTRA    ///
    mp = MediaPlayer.create(this, R.raw.birdsong);

    PhoneStateListener phoneStateListener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            if (mp.isPlaying() && state == TelephonyManager.CALL_STATE_RINGING) {
                mp.setVolume(0,0);
            } else if(mp.isPlaying() && state == TelephonyManager.CALL_STATE_IDLE) {
                mp.setVolume(1,1);
            } else if(mp.isPlaying() && state == TelephonyManager.CALL_STATE_OFFHOOK) {
                mp.setVolume(0,0);
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    };