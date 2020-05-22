// Setup the values for the toolbar's layout parameters.
    CoordinatorLayout.LayoutParams toolbarParams = new CoordinatorLayout.LayoutParams(
            CoordinatorLayout.LayoutParams.MATCH_PARENT,
            CoordinatorLayout.LayoutParams.WRAP_CONTENT
    );
    toolbarParams.setMargins(0, statusBarHeight, 0, 0);

    // Find, Assign, and Setup the Toolbar to take place of the Actionbar.
    // Then inflate the proper menu to be used on-top of it, and set its layout parameters
    // which have been set in the code above.
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.inflateMenu(R.menu.menu_main);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    toolbar.setLayoutParams(toolbarParams);