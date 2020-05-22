private void setupViewPager (ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());


        if(currentLocation.equals(config.roomone) {
        // for loop?
        adapter.addFragment(new table_new_main(),"INFO");
        adapter.addFragment(new table_one(),"TABLE 1"); 
        adapter.addFragment(new table_two(),"TABLE 2");
        adapter.addFragment(new table_three(),"TABLE 3");
    } else { ... }


        viewPager.setAdapter(adapter);

    }