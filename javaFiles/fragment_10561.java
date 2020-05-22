public void lilParser()  throws IOException, JSONException{

       URL url = new URL(API_URL + "/users/" + mSession.getId()
               + "/?access_token=" + mAccessToken);
       HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
       urlConnection.setRequestMethod("GET");
       urlConnection.setDoInput(true);
       urlConnection.connect();
       String response = Utils.streamToString(urlConnection
               .getInputStream());
       System.out.println(response);

       JSONObject jsonObj = (JSONObject) new JSONTokener(response).nextValue();
       JSONObject data_obj = jsonObj.getJSONObject("data");
       JSONObject counts_obj = data_obj.getJSONObject("counts");

       String name = jsonObj.getJSONObject("data").getString("full_name");
       String bio =jsonObj.getJSONObject("data").getString("bio");
       String counts=jsonObj.getJSONObject("data").getString("counts");

       userInfoHashmap.put(TAG_FOLLOWED_BY,counts_obj.getString(TAG_FOLLOWED_BY));
       Log.i(TAG,"followedby=>[" + counts + "]");
   }