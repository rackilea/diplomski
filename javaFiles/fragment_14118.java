tabHost = (TabHost)findViewById(R.id.tabHost);
tabHost.setup();

TabHost.TabSpec tab1 = tabs.newTabSpec("tab1");
tab1.setContent(R.id.tab1);
tab1.setIndicator("Tab 1");
tabHost.addTab(tab1);