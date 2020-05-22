String[] url ; // initiliaze your URL array here
   MediaPlayer myMediaPlayer = new MediaPlayer();
   myMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
   try { 
       myMediaPlayer.setDataSource(url[0]);
       myMediaPlayer.prepareAsync(); // might take long! (for buffering, etc)
   } catch (IOException e) {
       Toast.makeText(this, "mp3 not found", Toast.LENGTH_SHORT).show();
       e.printStackTrace();
   } 

   //mp3 will be started after completion of preparing... 
   myMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

       @Override 
       public void onPrepared(MediaPlayer player) {
           player.start();
       } 

   });