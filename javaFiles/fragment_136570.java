@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        //set the fragment for landscape mode
    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
         //Set the fragment for portrait mode
    }
}