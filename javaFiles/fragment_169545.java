@Override
    protected void onPreExecute(){
        super.onPreExecute();
        pDialog = new ProgressDialog(activityContext);
        pDialog.setMessage("Getting you the best warehouse sales...");
        pDialog.setCancelable(false);
        pDialog.show();
    }