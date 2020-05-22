public class AsyncTaskParseJson extends AsyncTask < String, String, String > {

    final String TAG = "AsyncTaskParseJson.java";
    ArrayList < String > myStringArray1 = new ArrayList < String > ();
    // contacts JSONArray
    JSONArray dataJsonArr = null;

    @Override
    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String...arg0) {

        try {

            // instantiate our json parser
            JSONParser jParser = new JSONParser();

            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            String userEmailVariable = settings.getString("variable1", "");

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl("path/to/jsonpage.php", userEmailVariable.toString());

            // get the array of users
            dataJsonArr = json.getJSONArray("Files");

            // loop through all users
            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);
                sometext = "";
                // Storing each json item in variable
                String id = c.getString("id");
                String type = c.getString("type");
                String name = c.getString("name");
                String icon = c.getString("icon");
                sometext = name.toString();

                if (icon.toString().length() == 0) {
                    icon = "default";
                }

                // show the values in our logcat
                Log.i(TAG, "type: " + type + ", name: " + name + ", icon: " + icon);

                myStringArray1.add(sometext);
            }

        } catch (JSONException e) {
            Log.i(TAG, "Errore LS: Errore del JSON in Files");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {
        populatelist(myStringArray1);
    }
}
public void populatelist(ArrayList <String> myStringArray1) {
    final String TAG = "Popolazione lista";
    ListView myListView = (ListView) findViewById(R.id.userContentList);

    ArrayAdapter < String > adapter = new ArrayAdapter < String > (getApplicationContext(), R.layout.list_item, R.id.file_list, myStringArray1);
    myListView.setAdapter(adapter);
    Log.i(TAG, name);
}