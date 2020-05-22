@Override
public void onPause(){
    super.onPause();

    song.release();
    song1.release();
    //and so on

}