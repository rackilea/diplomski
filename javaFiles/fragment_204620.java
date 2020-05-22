//Then in onCreate() of the new Activity...
 Bundle bundle = getIntent().getExtras();
 HashMap<String, String> movieDetails = (HashMap<String, String>) bundle.getSerializable("movieDetails");
 String dateReleased = movieDetails.get("dateReleased");
 String rating = movieDetails.get("rating");
 String title = movieDetails.get("title");