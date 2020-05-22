//Insert the Path here 
Uri myUri = Uri.parse(Environment.getExternalStorageDirectory().getPath())+"/Android/data/com.jorc.aud/test.mp3"); 
MediaPlayer mediaPlayer = new MediaPlayer();
mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
mediaPlayer.setDataSource(getApplicationContext(), myUri);
mediaPlayer.prepare();
mediaPlayer.start();