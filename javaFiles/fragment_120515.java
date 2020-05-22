@Override
public void onClick(View arg0)
{
    final ProgressDialog dialog = ProgressDialog.show(TankFinderActivity.this, "", "Loading. Please wait...", true);
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(filterTextSSD.getWindowToken(), 0);

    new AsyncTask<Void, Void, Void>()
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            loadsuchen();
            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            dialog.dismiss();
        }
    }.execute();
}