@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
       //do something
    }
    else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
       //do something        
    }
}