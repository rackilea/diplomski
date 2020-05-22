//======================================================  find tablayout
        TabLayout iTabLayout = (TabLayout) findViewById(R.id.tabLayoutMainXml);

    //======================================================  adding tabs to tablayout
    iTabLayout.addTab(iTabLayout.newTab());
    iTabLayout.addTab(iTabLayout.newTab());
    iTabLayout.addTab(iTabLayout.newTab());

    ArrayList<String> tabtitles = new ArrayList<String>();

    tabtitles.add("main");
    tabtitles.add("top");
    tabtitles.add("news");