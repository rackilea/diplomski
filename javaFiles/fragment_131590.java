AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
        @Override
        protected void onPreExecute() {
            // show dialog
        }

        @Override
        protected Void doInBackground(Void... params) {
            // connect to the server
        }

        @Override
        protected void onPostExecute(Void result) {
            // close dialog
        }
    };

    task.execute();