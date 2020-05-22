//logging omitted
JSONObject departuresJSONObj = response.getJSONObject("departures");
JSONArray allJSONArr = departuresJSONObj.getJSONArray("all");

JSONObject departureJSONObj;
String mode;

for (Object departureObj : allJSONArr) {

    if (departureObj instanceof JSONObject) {

        departureJSONObj = (JSONObject) departureObj;

        mode = departureJSONObj.getString("mode"); //mode is lowercase in the JSON
        TextViewResult.append(mode + "\n");

    }

}