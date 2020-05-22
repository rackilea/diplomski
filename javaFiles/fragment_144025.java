ActionBar actionBar = getActionBar();  //to support lower version too
actionBar.setDisplayShowHomeEnabled(false); // Remove icon
actionBar.setDisplayShowTitleEnabled(false); // Remove title text
actionBar.setDisplayShowCustomEnabled(true);
View customView=getLayoutInflater().inflate(R.layout.window_title, null);
actionBar.setCustomView(customView);
actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));