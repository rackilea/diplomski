@Override
public void onPause()
{
    super.onPause();
    if (youTubePlayer1 != null) {
        youTubePlayer1.release(); 
    }
}