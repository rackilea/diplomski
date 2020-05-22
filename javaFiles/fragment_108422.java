new AsyncTask<Void, Void, Void> () {
    protected Void doInBackground(Void... none) {
        //
        // your code
        //

        return null;
    }
    protected void onProgressUpdate(Void... none) {}
    protected void onPostExecute(Void none) {
        // use this to set the text

        final StringBuilder sb = ... ;
        final TextView tv = ... ;

        tv.setText(sb.toString());              
    }
}.execute();