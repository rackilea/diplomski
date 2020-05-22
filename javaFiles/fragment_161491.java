public void ongobuttonclick(View view) {

     ...
    //your code 

    //use AsyncTask if you  want ot inform ui thread
     final HttpClient httpclient = new DefaultHttpClient();
    final HttpPost httPost = new HttpPost(nnf);

    new AsyncTask<HttpPost, Void, HttpResponse>() {
        //YourParams, YourProgress, YourResult can be Void
        @Override
        protected HttpResponse doInBackground(HttpPost... params) {
            HttpResponse response = null;
            try {
               response = httpclient.execute(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(HttpResponse response) {
            if(response != null){
                //do sth in UI thread
            }
        }
    }.execute(httPost);

    //or in new thread if you doesn't want ot inform ui thread
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                httpclient.execute(httPost);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();
}