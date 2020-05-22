private class MyAsyncTask extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        ...
    }

    @Override
    protected String doInBackground(String... strings) {
        String someBitmap;

        ...

        return someBitmap;
    }

    @Override
    protected void onPostExecute(String /*instead Bitmap*/ result) {
        ...
    }
}