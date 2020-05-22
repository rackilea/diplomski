if (mp.isPlaying()) {
                    mp.stop();
                }
          if(mp!=null){
                     mp.release();
                    mp = new MediaPlayer();
               }