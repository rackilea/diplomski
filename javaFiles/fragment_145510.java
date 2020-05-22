@Override
protected void onPostExecute(String result) {
    // Set description into TextView
    txtdesc.setText(result);
    mProgressDialog.dismiss();
}