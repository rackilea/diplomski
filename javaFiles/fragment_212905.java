Configuration configuration = getResources().getConfiguration();
    configuration.fontScale = 1f; 
    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    metrics.scaledDensity = configuration.fontScale * metrics.density;
    configuration.densityDpi = (int) getResources().getDisplayMetrics().xdpi;
    getBaseContext().getResources().updateConfiguration(configuration, metrics);