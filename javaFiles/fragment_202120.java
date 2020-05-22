protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

// Getting JSON from URL
new JsonRequest().execute(url);

}

private class JsonRequest extends AsyncTask<String, Void, JSONObject>
// I will talk about the parameters to AsyncTask below
    @Override
    protected JSONObject doInBackground(String... urls) {
        // Creating new JSON Parser
        JSONParser jParser = new JSONParser();

        // Getting JSON from URL
        JSONObject json = jParser.getJSONFromUrl(url);

        return json;
    }


    @Override
    protected void onPostExecute(JSONObject result) {

        // Get the array
        JSONArray array = result.getJSONArray("data");

        // Display the data
        // Import textviews
        // and so on..
    }