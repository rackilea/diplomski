swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
swipeLayout.setOnRefreshListener(this);
swipeLayout.setColorScheme(
    android.R.color.holo_blue_bright, 
    android.R.color.holo_green_light, 
    android.R.color.holo_orange_light, 
    android.R.color.holo_red_light);