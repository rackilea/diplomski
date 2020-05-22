@Override
    protected void onPreExecute() {
        super.onPreExecute();
        PB.setVisibility(View.VISIBLE);
    }

   @Override
    protected String doInBackground(String... params) {
    shareVideo(finalVideoTitle, finalVideoLink, activity);
    }

   @Override
    protected void onPostExecute(String result){
     PB.setVisiblity(View.GONE);
    }