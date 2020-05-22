SoundPool mSoundPool;
int mSoundId;

//...

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
     mSoundPool = new SoundPool.Builder()
            .setMaxStreams(10)
            .build();
} else {
    mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
}

mSoundId = mSoundPool.load(this, R.raw.somesound, 1);

// ...

mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);