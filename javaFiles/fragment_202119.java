protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

// Creating new JSON Parser
JSONParser jParser = new JSONParser();

// Getting JSON from URL
JSONObject json = jParser.getJSONFromUrl(url);

// get the data from your JSONObject

}