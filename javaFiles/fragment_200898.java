new AsyncTask<Void, Void, Void>() {

        @Override
        protected void onPreExecute()
        {
             pd = ProgressDialog.show(getApplicationContext(),"", "Sending Image ...", true);
            Log.d(TAG, "onPreExecute()");
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            doFunction();
            return null;
        }

        @Override
        protected void onPostExecute(Void res)
        {
            Log.d(TAG, "onPostExecute()");
            pd.dismiss();
        }
    }.execute();