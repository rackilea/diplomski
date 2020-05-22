String text;
int value;
try {
     JSONObject jsonObject = new JSONObject(body);
     JSONArray rowArray = jsonObject.optJSONArray("rows");
     if(rowArray.length() > 0){
       JSONObject row = rowArray.optJSONObject(0);
       JSONArray elementArray = row.optJSONArray("elements");
       if(elementArray.length() > 0){
         JSONObject element = elementArray.optJSONObject(0);
         JSONObject distance = element.optJSONObject("distance");
         text = distance.optString("text");
         value = distance.optInt("value");
       }
     }
  } catch (JSONException e) {
    e.printStackTrace();
  }
Log.e("text", text);
Log.e("value", "value : " + value);