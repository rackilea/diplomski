mSoundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        Log.d(TAG, "soundpool onLoadComplete, sampleId = " + sampleId + ", status = " + status);

        // ... sound is ready to play            
    }
});

// sound load should happen off the UI thread
new Thread() {
    @Override
    public void run() {
        mSoundId = mSoundPool.load(getActivity(), R.raw.sound1, 1);
        // ... load other sounds here
    }
}.start();