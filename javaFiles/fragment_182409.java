//init here
mPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        // TODO Auto-generated method stub
        mPlayer1.stop();

        try {
            mPlayer1.reset();
            mPlayer2.setOnPreparedListener(new 
            MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    AppLog.logString("Start Playing Sound2");
                    mPlayer2.start();
                 }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPlayer1.release();
        AppLog.logString("Stop Playing Sound1");
    }
});