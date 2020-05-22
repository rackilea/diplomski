JSONObject jObj = new JSONObject(result);
JSONArray rows = jObj.getJSONArray("rows");
for(int i = 0; i < rows.length; i++){
     JSONObject obj = rows.getJSONObject(i);
     JSONArray elements = jObj.getJSONArray("elements");
     for(int j = 0; j < elements.length; j++){
          JSONObject Jobj = elements.getJSONObject(j);
          JSONObject distance = Jobj.getJSONObject("distance");
          int distance_value = distance.getInteger("value");
          JSONObject duration = Jobj.getJSONObject("duration");
          int duration_value = duration.getInteger("value");
     }
}