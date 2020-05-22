protected String doInBackground(String... args) {
    // Building Parameters
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    // getting JSON string from URL
    JSONObject json = jParser.makeHttpRequest(url_all_venues, "GET", params);

    if(json!=null){
    // Check your log cat for JSON reponse
        Log.d("All Venues: ", json.toString());
        try {
            // Checking for SUCCESS TAG
            int success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
            // venues found
            // Getting Array of Venues
                venues = json.getJSONArray(TAG_VENUES);
                // looping through All Venues
                if(venues !=null){
                    for (int i = 0; i < venues.length(); i++) {
                        JSONObject c = venues.getJSONObject(i);
                        // Storing each json item in variable
                        if(c!=null){
                            String id = c.getString(TAG_VENUE_ID);
                            String name = c.getString(TAG_VENUE_NAME);
                        }
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
                        // adding each child node to HashMap key => value
                        map.put(TAG_VENUE_ID, id);
                        map.put(TAG_VENUE_NAME, name);
                         // adding HashList to ArrayList
                        venuesList.add(map);
                    }   
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    return null;
}