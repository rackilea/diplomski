/**
 * Background Async Task to Load all Data from your HTTP Request
 * */
class LoadServerData extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... args) {
        String result = "";
        int id = 1;                     // your table ID value from somewhere
        string param2 = "someValue";    // your param if you have one
        double param3 = 1.1d;           // your param if you have one maybe a double value??
        try {
            // call the class where your 'selectYourData' method is
            ServerData dataServer = new ServerData(YourActivityClassName.this);
            result = dataServer.selectYourData(id, param2, param3);
        }
        catch (Exception ex) {
            Log.e(TAG, "LoadServerData --- " + ex.getMessage());
        }

        return result;
    }

    protected void onPostExecute(String result) {
        final String value = result;

        if(result.isEmpty()) {
            postEmptyList();
            return;
        }

        // If you have a lot of data you will want to organize it in its own thread
        // So you won't block the UI thread
        runOnUiThread(new Runnable() {
            public void run() {
                ListData data; // A custom class for holding your data - you will have to do this part
                Map<String, ListData> emailList = new LinkedHashMap<>();

                try {
                    JSONObject object = new JSONObject(value);
                    JSONArray array = object.getJSONArray("YourRootElementInJson");

                    int len = array.length();
                    if(len > 0) {
                        for (int i = 0; i < len; i++) {
                            final JSONObject o = array.getJSONObject(i);
                            data = new ListData();

                            int userId = o.getInt("col1");
                            data.setUserId(userID);

                            String userName = o.getString("col2");
                            data.setUserName(userName);

                            String email = o.getString("col3");
                            data.setUserEmail(email);

                            emailList.put(userName, data);
                        }
                    }
                }
                catch (JSONException jex){
                    Log.e(TAG, " onPostExecute --- " + jex.getMessage());
                }
                doSometingWithData(array);
            }
        });
    }
}