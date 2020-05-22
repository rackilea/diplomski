class YourRequestTask extends AsyncTask<Void, Void, JSONObject> {

        ProgressDialog progress;
        Context context;

        public YourRequestTask(Context context) {
             this.context = context;
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(context, null,"Please wait...");
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            //do your work here for your http request
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            progress.dismiss();
                        Log.i(TAG, "result is "+result.toString());
        }

    }