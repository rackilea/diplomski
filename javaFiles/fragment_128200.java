JSONObject jsonResponse;   
if(jsonResponse.has("Success")){
  JSONArray data = jsonResponse.optJSONArray("Success");
  //*********
}else{
  String error = jsonResponse.optJSONArray("fail").optJSONObject(0).optString("msg");
}