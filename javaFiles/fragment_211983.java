@Override
protected String doInBackground(String... params) {
return null;

String url5 = params[0];

// Creating new JSON Parser
JSONParser jParser = new JSONParser();

// Getting JSON from URL
JSONObject json = jParser.getJSONFromUrl(url5);

}//end doInBackground