@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);

    adapter.notifyDataSetChanged();
    // dismiss the dialog after getting all manufacturers
    if (pDialog.isShowing())
        pDialog.dismiss();
}