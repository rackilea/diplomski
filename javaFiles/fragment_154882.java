@Override
   public void onClick(View v) {

      switch (v.getId()) {
      case R.id.wmute:
        AudioManager.setMode(AudioManager.MODE_IN_CALL);
        AudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, true);
         break;
      default:
         break;
      }

   }