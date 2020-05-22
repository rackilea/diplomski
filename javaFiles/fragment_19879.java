public void playAudio(int audioId)
{
    // stop the previous playing audio
    if(mMediaPlayer != null && mMediaPlayer.isPlaying())
    {
        mMediaPlayer.stop();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }

    mMediaPlayer = MediaPlayer.create(this, audioId);

    mMediaPlayer.start();
    new Thread(new Runnable() { 
        public void run(){        
            while(true){
                if(mMediaPlayer.getCurrentPosition()-UpperTimeLimit >=0){ //UpperTimeLimit should be in milliseconds. UpperTimerLimit is the specific second after which player should start again the sound.
                    startPosition(initialTime);    //Call the startPosition(int initialTime)
                }
        }
    }).start();
}