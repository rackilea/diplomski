private class MyAsyncTask extends AsyncTask<String[], Void, Boolean> {
    //declare here local variables
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //prepare your local variables for the computation
    }

@Override
protected Boolean doInBackground(String[]... arg0) {

    String[] myStringArray = arg0[0];
    // make your manipulation of myStringArray

    return null; // return the result and set your local variable
}

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);

        //update ui using result and/or local variable
    }
}