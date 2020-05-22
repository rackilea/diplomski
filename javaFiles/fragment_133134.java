AudioManager am;
am= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);

//For Normal mode
am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

//For Silent mode
am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

//For Vibrate mode
am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);