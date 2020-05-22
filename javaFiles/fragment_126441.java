private void setColors(COLORS color) {
    int toolbarColor = 0;
    int statusbarColor = 0;
    switch (color) {
        case GREEN:
            setTheme(R.style.AppTheme_NoActionBar_Green);
            toolbarColor = R.color.green;
            statusbarColor = R.color.greenDark;
            break;
        case RED:
            setTheme(R.style.AppTheme_NoActionBar_Red);
            toolbarColor = R.color.red;
            statusbarColor = R.color.redDark;
            break;
        case BLUE:
            setTheme(R.style.AppTheme_NoActionBar_Blue);
            toolbarColor = R.color.blue;
            statusbarColor = R.color.blueDark;
            break;
    }
    mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, toolbarColor));
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, statusbarColor));
    }
}