Bundle bundle = getIntent().getExtras();
    if(bundle != null)
    {
        iv1.setColorFilter(bundle.getInt("COLOR_1",0));
        iv2.setColorFilter(bundle.getInt("COLOR_2",0));
        iv3.setColorFilter(bundle.getInt("COLOR_3",0));
    }