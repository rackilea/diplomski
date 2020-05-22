JSONObject rootJsonObject = new JSONObject(cycloneJSON);

// Create JSONArray associated with the key called "currenthurricane", which represents
// a list of cyclones from JSON response.
JSONArray currentHurricaneArray = rootJsonObject.getJSONArray("currenthurricane");

//Loop through each section in the currentHurricaneArray array & create an
//{@link CycloneData} object for each one
for (int i = 0; i < currentHurricaneArray.length(); i++) {
    //Get cyclone JSONObject at position i in the array
    JSONObject cycloneProperties = currentHurricaneArray.getJSONObject(i);

    // Extract "stormInfo" object
    JSONObject stormInfo = cycloneProperties.getJSONObject("stormInfo");
    //Extract “stormName_Nice” for Cyclone's name
    String name = stormInfo.optString("stormName_Nice");

    // Extract other values from cycloneProperties
    String url = cycloneProperties.optString("url");
    int category = cycloneProperties.optInt("SaffirSimpsonCategory");
    CycloneData cyclone = new CycloneData(category, name, url);
    //Add new cyclone to list
    cyclones.add(cyclone);
}