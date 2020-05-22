public class REST extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        HttpURLConnection urlConnection=null;
        String json = null;
        // The Username & Password
        final EditText em =  (EditText) findViewById(R.id.Username);
        String email = (String) em.getText().toString();
        final EditText pw =  (EditText) findViewById(R.id.Password);
        String password = (String) pw.getText().toString();
        // -----------------------

        try {
            HttpResponse response;
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("email", email);
            jsonObject.accumulate("password", password);
            json = jsonObject.toString();
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://cloudspecinc.herokuapp.com/api/user/login/");
            httpPost.setEntity(new StringEntity(json, "UTF-8"));
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Accept-Encoding", "application/json");
            httpPost.setHeader("Accept-Language", "en-US");
            response = httpClient.execute(httpPost);
            String sresponse = response.getEntity().toString();
            Log.w("QueingSystem", sresponse);
            Log.w("QueingSystem", EntityUtils.toString(response.getEntity()));
        }
        catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());

        } finally {
        /* nothing to do here */
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (result != null) {
            // do something
        } else {
            // error occured
        }
    }
}