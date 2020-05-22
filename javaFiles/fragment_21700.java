// Put values with intent. 
Intent intent_name = new Intent(nearby_place.this,geopoint.class);
intent_name.putExtra("longitude", "72");
intent_name.putExtra("latitude", "22");
startActivity(intent_name);

// Put values with intent. 
Intent intent_name = new Intent(city_search.this,geopoint.class);
intent_name.putExtra("longitude", "72");
intent_name.putExtra("latitude", "22");
startActivity(intent_name);

//Get values which comes with intent
// You can get the values of longitude & latitude in geopoint class as below method
int longitude = getIntent().getExtras().getInt("longitude");
int latitude = getIntent().getExtras().getInt("latitude");