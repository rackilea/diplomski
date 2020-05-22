private void playFile(){
 AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
         float actualVolume = (float) audioManager
                 .getStreamVolume(AudioManager.STREAM_MUSIC);
         float maxVolume = (float) audioManager
                 .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
         float volume = actualVolume / maxVolume;
         if (loaded) {
             mSoundPool.play(soundID, volume, volume, 1, 0, 1f);
             Log.e("Test", "Played sound");
         }
}