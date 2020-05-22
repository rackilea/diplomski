public void onCreate(Bundle savedInstanceState) {  
   ...
   tvSlidingMenuUserName = (TextView) findViewById(R.id.tvSlidingMenuUserName);
   ivSlidingMenuUserAvatar = (ImageView) findViewById(R.id.ivSlidingMenuUserAvatar);
  mUserDetailsDownloader = new UserDetailsAndStatsDownloader(currentlyLoggedInUserString, AsdActionBarAndSlidingMenu.this, AsdActionBarAndSlidingMenu.this);
                mUserDetailsDownloader.downloadUserDetailsAndStats();   
}