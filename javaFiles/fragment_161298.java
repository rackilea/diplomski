public class LoginTask extends AsyncTask<Void, Void, String>{
        private String username;
        private String password;
        private Context context;

        public LoginTask(Context context, String username, String password) {
            this.username = username;
            this.password = password;
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://fb.facenegah.com/android/login.php");
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("email", username));
                nameValuePairs.add(new BasicNameValuePair("pass", password));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                String responseText = EntityUtils.toString(entity);
                return responseText;
            }
            catch(Exception ex)
            {

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s != null) {
                Toast bread = Toast.makeText(context, s, Toast.LENGTH_LONG);
                bread.show();
            }
        }
    }