MediaPlayer mp;
int length;

//Inside constructor write this code
{
int resId = R.raw.a;
mp = MediaPlayer.create(this, resId);
}//End of Constructor



public void onClick(View v) {
    switch (v.getId()) {
    case R.id.play:
      mp.start();
      break;

    case R.id.pause:
    mp.pause();
    length = mp.getCurrentPosition();
    break;

   case R.id.resume:
     if(!mp.isPlaying()) {
     mp.seekTo(length);
     mp.start();
     }
     break;

   case R.id.stop:
    mp.stop();
    break; 
    }
}