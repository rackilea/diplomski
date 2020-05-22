MediaPlayer mp;
@Override
public void onCreate(){
mp = new MediaPlayer();
mp.setOnPreparedListener(this);
}
public void prepareplayer(){
mp.setDataSource(Url);
mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
Log.d(TAG, "Preparing..");
mp.prepareAsync();
}

@Override
public void onPrepared(MediaPlayer mp) {
// TODO Auto-generated method stub
Log.d(TAG, "Prepared");
mp.play();
}