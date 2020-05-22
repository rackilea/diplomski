private class MyPost extends AsyncTask<Void,Void,Void>{

    @Override
    protected Void doInBackground(Void... arg0) {
        // TODO Auto-generated method stub
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://cdobiz.com/submit/");

        try {
            // Add your data

            EditText txtName = (EditText)findViewById(R.id.txtBusinessName);
            EditText txtDesc = (EditText)findViewById(R.id.txtDescription);

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("frmName",txtName.getText().toString() ));
            nameValuePairs.add(new BasicNameValuePair("frmDesc", txtDesc.getText().toString()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            Log.v("Post Status","Code: "+response.getStatusLine().getStatusCode());
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }

}