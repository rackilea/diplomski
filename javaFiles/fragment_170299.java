class TheTask extends AsyncTask<String,String,String>
    {

@Override
protected String onPostExecute(Void result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);
    // update textview here
    textView.setText("Server message is "+result);
}

@Override
protected void onPreExecute() {
    // TODO Auto-generated method stub
    super.onPreExecute();
}

@Override
protected String doInBackground(String... params) {
     try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost method = new HttpPost(params[0]);
            HttpResponse response = httpclient.execute(method);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                return EntityUtils.toString(entity);
            }
            else{
                return "No string.";
            }
         }
         catch(Exception e){
             return "Network problem";
         }

}
}