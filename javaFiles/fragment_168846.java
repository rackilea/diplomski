class YourClass extends AsyncTask<...>
{
    ProgressDialog dialog;
    Protected void onPreExecute(){
        // create dialog here
       dialog= new ProgressDialog (...);
    }
    protected void onPostExecute(Bitmap image){
        //
        dialog.dismiss();
    }
}