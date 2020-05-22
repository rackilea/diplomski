private void updateVideoViews(final boolean remoteVisible) {
    activity.runOnUiThread(() -> {
        ViewGroup.LayoutParams params = localVideoView.getLayoutParams();
        ViewGroup.LayoutParams params2 = remoteVideoView.getLayoutParams();
        if (remoteVisible) {
            params.height = dpToPx(100);
            params.width = dpToPx(100);

            params2.height = dpToPx(100);
            params2.width = dpToPx(100);
        } else {
            params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params2 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        localVideoView.setLayoutParams(params);
        remoteVideoView.setLayoutParams(params2);
    });
}

public int dpToPx(int dp) {
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
}