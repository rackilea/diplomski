TabHost.TabSpec spec1,spec2,spec3;  // Resusable TabSpec for each tab
Intent intent1,intent2,intent3;
intent1 = new Intent().setClass(this, HaffActivity.class);

// Initialize a TabSpec for each tab and add it to the TabHost
spec1 = tabHost.newTabSpec("Haff").setIndicator("Haff",
                  res.getDrawable(R.drawable.ic_tab_haff))
              .setContent(intent1);
tabHost.addTab(spec);

// Do the same for the other tabs
intent2 = new Intent().setClass(this, MapsActivity.class);
spec2 = tabHost.newTabSpec("Maps").setIndicator("Maps",
                  res.getDrawable(R.drawable.ic_tab_maps))
              .setContent(intent2);
tabHost.addTab(spec);

intent3 = new Intent().setClass(this, ProfileActivity.class);
spec3 = tabHost.newTabSpec("Profile").setIndicator("Profile",
                  res.getDrawable(R.drawable.ic_tab_profile))
              .setContent(intent3);
tabHost.addTab(spec);