setContentView(R.layout.main);
    Resources res = getResources();

    TabHost tabHost = getTabHost();
    TabHost.TabSpec spec;
    Intent intent;

    intent = new Intent().setClass(this, Personal.class);
    spec = tabHost.newTabSpec("personal").setIndicator("Personal").setContent(intent);
    tabHost.addTab(spec);