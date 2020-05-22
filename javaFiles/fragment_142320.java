GraphRequest request = GraphRequest.newMeRequest(
            loginResult.getAccessToken(),
            new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(
                 final JSONObject object,
                 GraphResponse response) {
                 // Application code
                 final JSONObject jsonObject = response.getJSONObject();
                 String first_name = "";
                 String last_name = "";
                 try {
                      first_name = jsonObject.getString("first_name");
                      last_name =  jsonObject.getString("last_name"); 
                      JSONObject friends = jsonObject.getJSONObject("friends");
                      JSONArray data = friends.getJSONArray("data");
                      JSONObject objectdata = data.getJSONObject(0);
                      String friend_first_name = objectdata.getString("first_name");
                      String friend_last_name = objectdata.getString("last_name");
                 } catch (JSONException e) {
                      e.printStackTrace();
                 }});