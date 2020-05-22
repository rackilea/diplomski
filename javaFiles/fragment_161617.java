private class LogoTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPreExecute() {
        pw = (ProgressWheel) findViewById(R.id.pw_spinner);
        pw.spin();//Ui elements should run in ui thread
    }
    @Override
    protected Void doInBackground(Void... params) {
       //network operations here
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        //stop progress wheel or dismiss
    }
}