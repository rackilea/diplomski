private class AsyncCaller extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //this method will be running on UI thread
        //can call progress bar here to show loading process
    }

    @Override
    protected Void doInBackground(Void... params) {

        //this method will be running on background thread 
        //so don't update UI from here
        //do your long running http tasks here,
        //you don't want to pass argument and you
        //can access the parent class' variable url over here

        // call your server data here
        serverListManager.getServerList();
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        //this method will be running on UI thread
        //Show the result obtained from doInBackground
        //this executed after doInBackground so after you get data from doInBackground
        //you can set your adapter here
    }

}