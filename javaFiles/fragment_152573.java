Tab tab = ab.newTab()
        .setText("TY1")
        .setTabListener(new MyTabListener(this, TY1.class.getName()));
View tabView = inflater.inflate(R.layout.my_tab_layout, null);
tabView.setBackgroundColor(...); // set custom color
tab.setCustomView(tabView);
ab.addTab(tab);