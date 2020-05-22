private void showProgressAndDownloadDDBB() {
    progressDialog = new ProgressDialog(mContext);
    progressDialog.setCancelable(false);
    progressDialog.setIndeterminate(true);
    progressDialog.show();
    // Here I call the Runnable to execute the code in other Thread and let the UI draw the Progress Dialog. If it wasn't called, the progress dialog does appear.
    DDBB_Download_Manager ddbb_download_manager = new DDBB_Download_Manager(mContext, progressDialog);
    Handler handler = new Handler();
    handler.postDelayed(ddbb_download_manager ,3*1000);
}