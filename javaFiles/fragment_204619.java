//You would put each set of movie data into a HashMap like this...
HashMap<String, HashMap<String, String>> movies = new HashMap<>();

HashMap<String, String> details = new HashMap<>();
details.put("dateReleased", "7.12.2015");
details.put("rating", "PG-13");
details.put("title", "Cool Awesome Movie");
movies.put("12345", details);

//Then when an onClick comes in, you would get the set of 
//details for the movie that was selected (based on position)
HashMap<String, String> selectedDetails = movies.get("12345");

//Put the retrieved HashMap of details into a Bundle
Bundle bundle = new Bundle();
bundle.putSerializable("movieDetails", selectedDetails);

//Send the bundle over to the new Activity with the intent
Intent intent = new Intent(this, YourDetailsActivity.class);
intent.putExtras(bundle);
startActivity(intent);