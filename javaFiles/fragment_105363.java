int current_orientation = getResources().getConfiguration().orientation;
if (current_orientation == Configuration.ORIENTATION_LANDSCAPE) {
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
} else {
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
}