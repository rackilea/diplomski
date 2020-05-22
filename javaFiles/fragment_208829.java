public SomeTask extends AsyncTask<DecodeResult, String, String> {
    private Container container;
    public someTask(Container container){
        this.container = container; 
    }
    public void doInBackground(String ... args) { 
        while (rs.next()) {
            Log.i("OPERATOR IDENTIFIED", rs.getString(4));
            publishProgress("OPERATOR IDENTIFIED " + rs.getString(2));
        }
    }
    void onProgressUpdate(String step){
         this.mCallBack.updateMyText(step);
    }
}