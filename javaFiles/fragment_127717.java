new AsyncTask<Void, Void, Void>() {

    public void doInBackground(Void... params,) {
        //do your loading here
        return null;
    }

    public void onPostExecute(Void result) {
        //update your ui here when loading finishes
    }

}.execute();