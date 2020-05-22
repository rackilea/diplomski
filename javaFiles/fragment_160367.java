TabHost tabHost = getTabHost();

// Tab for Photos
TabSpec photospec = tabHost.newTabSpec("Photos");
// setting Title and Icon for the Tab
photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.icon_photos_tab));
Intent photosIntent = new Intent(this, PhotosActivity.class);
photospec.setContent(photosIntent);

// Tab for Songs
TabSpec songspec = tabHost.newTabSpec("Songs");
songspec.setIndicator("Songs", getResources().getDrawable(R.drawable.icon_songs_tab));
Intent songsIntent = new Intent(this, SongsActivity.class);
songspec.setContent(songsIntent);
 // Adding all TabSpec to TabHost
tabHost.addTab(photospec); // Adding photos tab
tabHost.addTab(songspec); // Adding songs tab