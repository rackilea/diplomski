ProgressDialog progressDialog;


public void showPD(String message) {
    if (progressDialog == null) {
        progressDialog = new ProgressDialog(getContext());
        //progressDialog.setProgressNumberFormat(null);
        //progressDialog.setProgressPercentFormat(null);
        //progressDialog.setIndeterminate(true);
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }
}

public void hidePD() {
    if (progressDialog != null) {
        progressDialog.dismiss();
        progressDialog = null;
    }
}