protected void onPostExecute(String unused) {
    //dismiss the dialog after the file was downloaded
    dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
    if(unused != null && unused.equals("ERROR_IN_CODE")){
        showDialog(SOME_DIALOG_TO_SHOW_ERROR);
    }
}