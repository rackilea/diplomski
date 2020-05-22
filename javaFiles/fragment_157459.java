private class loadMoreListView extends AsyncTask<Void, Void, Void> {

    ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        pDialog = new ProgressDialog(SingleMenuItemActivity.this);
        pDialog.setMessage("Please Wait ...");
        pDialog.isIndeterminate();
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        pDialog.cancel();

    }

}