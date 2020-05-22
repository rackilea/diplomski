public void submitDataOnServer(final ArrayList<NameValuePair> nameValuePairs){
        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... params) {
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.137/Android/App/getInsert.php");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();

                    Log.e("log_tag", "connection success ");
                    System.out.println("Zero");
                    //Toast.makeText(getApplicationContext(), "Subscription Successfull.Thank You for Subscribing you have now been added to our Mailing Lists", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection " + e.toString());
                    //Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();
                }
                try {
                    System.out.println("First");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    System.out.println("Second");
                    System.out.println("After Second:"+reader.readLine());
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");

                    }
                    is.close();
                    System.out.println("Third");
                    result=sb.toString();
                } catch (Exception e) {
                    System.out.println("Fourth");
                    Log.e("log_tag", "Error converting result " + e.toString());
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                try {
                    System.out.println("Fifth");
                    JSONObject json_data = new JSONObject(result);
                    CharSequence w = (CharSequence) json_data.get("result");

                    Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    Log.e("log_tag", "Error parsing data " + e.toString());
                    System.out.println("sixth");
                    Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }