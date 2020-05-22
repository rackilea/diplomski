@Override
public void onResponse(Response response) throws IOException {
    try {
        fullObject = new JSONObject(response.body().string());
        JSONArray s = fullObject.names();
        for(int i=0; i<s.length(); i++) {
            JSONArray citiesOfOneCoutry = null;
            citiesOfOneCoutry = fullObject.getJSONArray(s.getString(i));
            for(int j=0; j<citiesOfOneCoutry.length();j++) {
                allCities.add(citiesOfOneCoutry.getString(j));
            }
            Log.d(TAG, "onResponse: in for "+allCities.size());
        }
        Log.d(TAG, "onResponse: outside for "+allCities.size()); //gives full size.
    } catch (JSONException e) {
         e.printStackTrace();
    }
    Log.d(TAG, "onResponse: outside try "+allCities.size()); //gives full size
    updateUI();
}