static int fontScale = 1;
static int densityDpi = 0;

public void onConfigurationChanged(Configuration newConfig) {
  if (newConfig.fontScale != fontScale) {
    // destroy and recreate dialog adjusting for font size.
    fontScale = newConfig.fontScale;
  }
  if (newConfig.densityDpi != densityDpi) {
    // destroy and recreate dialog adjusting for new screen size.
    densityDpi = newConfig.densityDpi;
  }
}