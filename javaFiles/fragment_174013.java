private ProgressDialog dialog;
private class PrefetchData extends AsyncTask<Void, Void, Void> {

@Override
protected void onPreExecute() {
    super.onPreExecute();
    dialog = new ProgressDialog(getActivity());
    dialog.setMessage("Downloading..");
    dialog.setIndeterminate(true);
    dialog.setCancelable(true);
    dialog.show();
}

@Override
protected Void doInBackground(Void... arg0) {
    HttpReader httpReader = new HttpReader();
    httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
                @Override
                public void resultReady(String result) {
                    JsonHelper jsonHelper = new JsonHelper();
                    tickets = jsonHelper.getTickets(result);
                    //finished the download and we dismiss the dialog
                    dialog.dismiss();
                }
            });
    httpReader.execute(url);
    return null;
}

@Override
protected void onPostExecute(Void result) {
    super.onPostExecute(result);
}