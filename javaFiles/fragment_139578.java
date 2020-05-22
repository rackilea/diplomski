try {

     mp.setDataSource(file_url);

    mp.setOnPreparedListener(new OnPreparedListener() {
         public void onPrepared(MediaPlayer player) {

                player.start();
        }
     });
    mp.prepareAsync();