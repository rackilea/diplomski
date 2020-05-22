new AsyncTask<Context, Void, Void>() {

        //local fields

        @Override
        protected void onPreExecute() {
            //runs on UI Thread
        }

        @Override
        protected void onCancelled() {
           /* runs on UI Thread instead of onPostExecute()
               if cancel(boolean) was called */
        }

        @Override
        protected void onProgressUpdate(Progress... values) {
            //runs on UI Thread
        }

        @Override
        protected Void doInBackground(Context... params) {
          //background Thread - do heavy work here
            Context c = params[0];
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
          //runs on UI Thread
        }

    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mContext);