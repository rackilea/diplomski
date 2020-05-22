JSONObject data = new JSONObject(result);
 // add log here ,make sure you have photos in your result
 Log.e("result", result + "");
 if (data.getString("status").equalsIgnoreCase("OK")) {
     // edited here
     JSONArray photoArray = data.optJSONArray("photos");
 }