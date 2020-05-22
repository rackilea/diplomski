@Override
public void onResume() {
    Log.i(TAG, ""+TAG); //TAG represents the name of the current activity/fragment    
    mTracker.setScreenName("Screen name: " + TAG); //added line
    mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    super.onResume();
}