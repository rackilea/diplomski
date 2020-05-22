JSONObject authData;
    JSONObject wrapper;

    @Override
    protected void onPreExecute() {
        try {
            authData = new JSONObject();
            wrapper = new JSONObject();
            JSONObject twitterAuth = new JSONObject();
            twitterAuth.put("id", Long.toString(twitterUser.getId()));
            twitterAuth.put("screen_name", twitterUser.getScreenName());
            twitterAuth.put("consumer_key", CONSUMER_KEY);
            twitterAuth.put("consumer_secret", CONSUMER_SECRET);
            twitterAuth.put("auth_token", accessToken.getToken());
            twitterAuth.put("auth_token_secret", accessToken.getTokenSecret());
            authData.put("twitter", twitterAuth);
            wrapper.put("authData", authData);


        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected Boolean doInBackground(String... args) {
        // Send the HttpPostRequest and receive a JSONObject in return
        JSONObject jsonObjRecv = JSONRequest.SendHttpGet("https://api.parse.com/1/users/", wrapper);

        return true;
    }
    @Override
    protected void onPostExecute(Boolean response) {

    }