if (lightMode) {
        setTheme(R.style.AppTheme_Light_NoActionBar);
        getWindow().getDecorView().setSystemUiVisibility
               (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | 
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }