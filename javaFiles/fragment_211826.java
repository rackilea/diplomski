mToolbar = (CustomToolbar) findViewById(R.id.toolbar);

        setUpCustomUpNavigation();

        setSupportActionBar(mToolbar);

        // to disable title in a toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);