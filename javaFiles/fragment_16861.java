private void initializeSoundPool(){
        mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                public void onLoadComplete(SoundPool soundPool, int sampleId,
                        int status) {
                    loaded = true;
                }
            });
            soundID = mSoundPool.load(this, R.raw.glassbreak, 1);        
        }