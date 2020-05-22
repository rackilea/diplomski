@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    //if you need change layout then do:  
    switch(newConfig.orientation) {
        case Configuration.ORIENTATION_LANDSCAPE:
            setContentView(layout_landscape)
            break;
        case Configuration.ORIENTATION_PORTRAIT:
            setContentView(layout_portrait);
            break;
    }
}