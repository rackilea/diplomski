private ProgressDialog progressDialog;
private Context context;

public InitializePresentation (Context context) {
    this.context = context;
}

@Override
protected void onPreExecute() {
    progressDialog = ProgressDialog.show(context, "", "loading", true);
}

/* 
 * @see android.os.AsyncTask#doInBackground(Params[])
 */
@Override
protected String doInBackground(String... arg0) {
    // Do the networking stuff here
}

@Override
protected void onPostExecute(final String result) {
    progressDialog.dismiss();
}