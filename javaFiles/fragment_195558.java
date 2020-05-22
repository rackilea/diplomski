private void URL() 
    {
        String url = txtURL.getText().toString();
        new URLTask().execute(new String[] { url });
    }    




private class URLTask extends AsyncTask<String, Void, String> 
    {
        protected String doInBackground(String... urls)
        {

            BufferedReader br = null;
            String url = urls[0];
            StringBuffer sb = new StringBuffer("");

            try
            {
                HttpClient client = new DefaultHttpClient();
                HttpPost request = new HttpPost();
                request.setURI(new URI(url));

                List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                postParameters.add(new BasicNameValuePair("param1", "value of param1")); 

                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);         

                request.setEntity(formEntity);
                HttpResponse response = client.execute(request);

                String line;

                br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while ((line = br.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                br.close();

            } 
            catch(Exception e)
            {
                Toast.makeText(HttpPostActivity.this, "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
            }
            finally 
            {
                if (br != null) 
                {
                    try 
                    {
                        br.close();
                    } 
                    catch(IOException ioe) 
                    {
                        ioe.printStackTrace();
                    }
                }           

            }           

            return(sb.toString());
        }


        protected void onPostExecute(String result) 
        {
            txtContent.setText(result);
        }