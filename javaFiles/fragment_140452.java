public class AsyncTaskGetResult extends AsyncTask<String, String, String> {

    PrintListner mPrintListner ;      
    private AsyncTaskGetResult (PrintListner mPrintListner) {
        this.mPrintListner = mPrintListner;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected String doInBackground(String... params) {
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
    //heare result is value you return from doInBackground() method 
    //this is work on UI thread
    this.mPrintListner.getResult(result);
   }