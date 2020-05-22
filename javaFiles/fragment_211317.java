boolean found = false;

void getIPAddress()  {

  for (int i = 1; i < 255; i++) {
    if (!found) {
        String tryIP = subnet + String.valueOf(i);
        Log.d(TAG, "Trying: " + tryIP);
        final String finalIP = tryIP;

        try {

                SyncHttpClient client = new SyncHttpClient();
                RequestParams params = new RequestParams();
                params.put("check", "1");

                client.get("http://" + finalIP , params, new JsonHttpResponseHandler() {



                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {

                            JSONObject jo = response;
                            String key = jo.getString("controller");
                            Log.d(TAG, "Success : " + response + " and key is : " + key);

                            if (key.equals("esplight")) {

                                Log.d(TAG, "Found the ESP! Its IP is :" + finalIP);

                                found = true;


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

                        Log.d(TAG, "trying to connect failed ");

                    }
                });


          } catch (Exception e) {
        }
    }
 }
}