@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
    layoutParams.height = parentView.getHeight() - 1;
    videoView.setLayoutParams(layoutParams);
}