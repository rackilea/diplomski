JSONObject jObject = new JSONObject(result); 
JSONObject jBody = jObject.getJSONObject("Body");
JSONObject jAuthResponse = jBody.getJSONObject("AuthResponse");
JSONArray jauthToken = jAuthResponse.getJSONArray("authToken");
JSONObject jFirst = jauthToken.getJSONObject(0);
String aJsonString = jObject.getString("_content");