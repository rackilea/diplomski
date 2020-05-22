mDrawer = (DrawerLayout) findViewById(R.id.drawer);
    mDrawerList = (ListView) findViewById(R.id.left_wrapper);

    String[] names = { "Create", "Show up", "Hide out", "WebView", "Registration", "LogIn View" };
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, names);

    mDrawerList.setAdapter(adapter);

    mDrawerList.setOnItemClickListener(new DrawerItemClickListener());