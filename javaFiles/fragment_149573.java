public void changeOrientation() {

    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    } else {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    }
}