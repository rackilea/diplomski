protected void onResume() {
    super.onResume();

    View decorView = getWindow().getDecorView();
    int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN;

    decorView.setSystemUiVisibility(uiOptions);
}