// get lat and lng value
JSONObject ret = getLocationInfo(lat, lng); 
JSONObject location;
String location_string;
try {
    //Get JSON Array called "results" and then get the 0th complete object as JSON        
    location = ret.getJSONArray("results").getJSONObject(0); 
    // Get the value of the attribute whose name is "formatted_string"
    location_string = location.getString("formatted_address");
    Log.d("test", "formattted address:" + location_string);
} catch (JSONException e1) {
    e1.printStackTrace();

}