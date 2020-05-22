private static final int DOWNLOAD_ONPROGRESS = 1;

@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
    case DOWNLOAD_ONPROGRESS:
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Downloading latest ...");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        try {
            progressDialog.show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return progressDialog;
    default:
        return null;
    }
}