new AsyncTask<Object, Object, Boolean>() {
        @Override
        protected void onPreExecute() {
        //              mPD = new ProgressDialog(InitActivity.this);
        //              mPD.setCancelable(false);
        //      PD.setMessage(getString(R.string.vitamio_init_decoders));
        //              mPD.show();
        }

        @Override
        protected Boolean doInBackground(Object... params) {
            return Vitamio.initialize(MyMapActivity.this);
        }

        @Override
        protected void onPostExecute(Boolean inited) {
        //              if (inited) {
        //                  uiHandler.sendEmptyMessage(0);
        //              }
        }

    }.execute();