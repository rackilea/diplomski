//Async caller for threading
        class AsyncCaller extends AsyncTask<Void, Void, Void>
        {

            public AsyncCaller()
            {
               //initialize anything you may need here
            }

            ProgressDialog pdLoading = new ProgressDialog(/*Application Context here*/);
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread, so change any UI here
                pdLoading.setMessage("Set loading message here");

                pdLoading.show();
            }
            @Override
            protected Void doInBackground(Void... params) {

                //this method will be running on background thread so don't update UI frome here
                //do your long running tasks here


                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                //put anything you need after execution here. 

                pdLoading.dismiss();
            }

        }