class Test extends AsyncTask<String, Void, JSONObject>{

    @Override
    protected JSONObject doInBackground(String... params) {
      JSONObject jObject = null;
        try {
          String accountInfo = params[0];
          String input_url = params[1];
            // Establish Connection
            URL url = new URL(input_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            // Post account info to server
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(accountInfo);
            wr.flush();
            wr.close();

            // Check response code and message
            int responseCode = con.getResponseCode();
            InputStream is = con.getErrorStream();
            String contentAsString = CovertToString(is, 500);
            jObject = new JSONObject(contentAsString);
            jObject.put("response", responseCode);

        }catch (IOException e) {
            e.printStackTrace();
        }

      return jObject;

    }

    protected void onPostExecute(JSONObject data) {
     // do some things with JSONObject as this runs on UI thread.

  }

}