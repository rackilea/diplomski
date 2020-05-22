@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if (newConfig.getConfiguration() == Configuration.ORIENTATION_LANDSCAPE) {
        setContentView(landscape_layout);
    } else {
        setContentView(portrait_layout);
    }
    initViews();
}