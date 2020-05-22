@Override 
public void onCreate() {
AudioManager myAudioManager;
myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
}