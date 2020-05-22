public class  ParsingTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>{


 JSONParser Parser = new JSONParser();

 protected Void doInBackground(String... urls) {

ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
JSONObject json = Parser.getJSONFromUrl(url);

try {
    // Getting Array of Contacts
    data = json.getJSONArray(TAG_DATA);

    // looping through All Contacts
    for(int i = 0; i < data.length(); i++){
        JSONObject c = data.getJSONObject(i);

        // Storing each json item in variable
        String streamer = c.getString(TAG_STREAMER);
        String viewers = c.getString(TAG_VIEWERS);
        //String link = c.getString();

        // creating new HashMap
        HashMap<String, String> map = new HashMap<String, String>();

        // adding each child node to HashMap key => value
        map.put(TAG_STREAMER, streamer);
        map.put(TAG_VIEWERS, viewers);
        //map.put(TAG_URL, link);

        // adding HashList to ArrayList
        dataList.add(map);
    }
} catch (JSONException e) {
    e.printStackTrace();
}

/**
 * Updating parsed JSON data into ListView
 * */


return dataList;
  }

 protected void onPostExecute(ArrayList<HashMap<String, String>> dataList) {
  ListAdapter adapter = new SimpleAdapter(AndroidJSONParsingActivity.this, dataList,
        R.layout.list_item,
        new String[] { TAG_STREAMER, TAG_VIEWERS /*TAG_URL*/ }, new int[] {
        R.id.streamer, R.id.viewers /*R.id.url*/ });

setListAdapter(adapter);
    }