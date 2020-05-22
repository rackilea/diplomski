@Override
protected void onPreExecute() {
    super.onPreExecute();
    pDialog = new ProgressDialog(NewJobActivity.this);
    pDialog.setMessage("Creating Job..");
    pDialog.setIndeterminate(false);
    pDialog.setCancelable(true);
    pDialog.show();
}