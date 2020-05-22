JSONArray tracks = JSONfunctions.getJSONfromURL("http://www.somesite.com/json");
if(tracks != null) {

    for(int i = 0; i < tracks.length(); i++) {

        try {

            Log.d("track@" + i, tracks.getJSONObject(i).getString("track"));
        } 
        catch (JSONException e) {

            e.printStackTrace();
        }
    }
}