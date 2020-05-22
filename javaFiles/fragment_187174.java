class GetStuffAsyncly extends AsyncTask<String, String, String> {
    String dialogString;
    ProgressDialog dialog;
    Context context;
    AsyncListener listener;
    // my vars....

    public GetStuffAsyncly(String dialogMessage, Context con, AsyncListener listener) {
        this.dialog = new ProgressDialog(con);
        this.dialogString = dialogMessage;
        this.context = con;
        this.listener = listener;
    }

    /**
     * Before starting background thread Show Progress Dialog
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onTaskStarted();
    }

    @Override
    protected String doInBackground(String... args) {
        // do stuff in background...

        return data;
    }

    /**
     * After completing background task Dismiss the progress dialog
     **/
    protected void onPostExecute(String jsonString) {
        // dismiss the dialog after getting all data
        dialog.dismiss();
        listener.onTaskFinished(jsonString);
    }
}