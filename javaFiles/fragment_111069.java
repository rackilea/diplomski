public void InitializeAudio(Context context)
{
   Log.d("TEST", "initAudio method called");
   sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
   Log.d("TEST", "sound pool created sp= " + sp);
   shot = sp.load(context, R.raw.gunshot, 1);
   Log.d("TEST", "Audio is loaded :)");
}