try {
     JSONObject mainObject = new JSONObject(data);
     JSONArray jsonArray = mainObject.getJSONArray("resource");
     JSONObject resourceObject = jsonArray.getJSONObject(0);
     String lat = resourceObject.getString("lat");
     String lng = resourceObject.getString("lon");
     String devid = resourceObject.getString("devid");
     String time = resourceObject.getString("time");
     String speed = resourceObject.getString("speed");
     String pInt = resourceObject.getString("pInt");
     String result = resourceObject.getString("result");
} catch (Exception e) {
     e.printStackTrace();
}