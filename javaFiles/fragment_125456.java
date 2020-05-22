AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
switch(audioManager.getRingerMode()){
   case AudioManager.RINGER_MODE_NORMAL:
      // Phone is loud
      break;

   case AudioManager.RINGER_MODE_SILENT:
      // Phone is silent
      break;

   case AudioManager.RINGER_MODE_VIBRATE:
      // Phone is vibrating
      break;
}