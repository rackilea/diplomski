ServiceHandler sh = new ServiceHandler();
List<NameValuePair> params = new ArrayList<NameValuePair>();

@Override
protected void onPreExecute() {
    // TODO Auto-generated method stub
    super.onPreExecute();


    params.add(new BasicNameValuePair("pkey", "pvalue"));

}

@Override
protected String doInBackground(String... param) {
        // TODO Auto-generated method stub
        String json;
        try {
            json = sh.makeServiceCall(url, ServiceHandler.POST, params);

            Log.d("Response: ", "> " + json);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

@Override
protected void onPostExecute(String result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);


    }