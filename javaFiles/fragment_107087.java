private ProgressDialog dialog;
private ConnectivityManager cm;
String jsonurl, jsonstring;
mobile_form mform;
private  mContext context;

public background (Context ctx){
    this.mContext = ctx;
    this.cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    this.dialog = new ProgressDialog(ctx);
    mform = new mobile_form();
}

//...
// doInBackground()
//...

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
       NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            if (dialog.isShowing())
                dialog.dismiss();
        }
        mContext.startActivity(new Intent(mContext, mobile_form.class));
    }