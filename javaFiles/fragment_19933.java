@Override
public void onWindowFocusChanged(boolean hasFocus) {
    SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    boolean box = getPrefs.getBoolean("pref_brightness", true);     
    if (box == true) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = 100 / 100.0f;
        getWindow().setAttributes(lp);
    }
    else{
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = -1;
        getWindow().setAttributes(lp);
    }
    super.onWindowFocusChanged(hasFocus);
}