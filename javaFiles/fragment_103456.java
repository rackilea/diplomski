ProgressDialog progressDialog;;
protected void onCreate(...) {
   //...code
    progressDialog = new ProgressDialog(activity);
    progressDialog.setCancelable(false);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressDialog.setTitle("Fetching App List");
    progressDialog.setMessage("Please Wait...");

}

private void prod() {
    progressDialog.show();
}