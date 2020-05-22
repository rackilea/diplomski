try {
          mPlayer.reset();
          mPlayer.setDataSource(someUrl);
          mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
             @Override
              public void onPrepared(MediaPlayer mediaPlayer) {
                   //bam!
              }
          });
          mPlayer.prepareAsync();
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    }