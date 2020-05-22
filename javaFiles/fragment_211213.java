private class sendPost extends AsyncTask<String, Void, String>
{
    @Override
    protected String doInBackground(String... params)
    {
         // ADDITION
         String user = params[0];
         String password = params[1];
         // END ADDITION             

         // use them in the request
         // rest of code...

    }
}