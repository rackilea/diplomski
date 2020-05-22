private class PostData extends AsyncTask<String, Void, String>
    {
        protected void onPreExecute()
        {
            apply.setText("APPLYING...");
        }
        @Override
        protected String doInBackground(String... params) {
            String response;
            try {
                SendHTTPData sendHTTPData = new SendHTTPData();
                response = sendHTTPData.sendData(params);
            }
            catch(Exception e)
            {
                Log.e("someTag", "Caught exception after doinbackground");
                response = "ERROR!";
            }
                return response;
        }
        @Override
        protected void onPostExecute(String response)
        {
            apply.setText(response);
        }
}