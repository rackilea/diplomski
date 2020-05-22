private class ProcessData extends AsyncTask<String, Void, Boolean> {

 @Override
protected Boolean doInBackground(String... params) 
{
    //your code here
    boolean bool = true;
return bool;
}

@Override
 protected void onPostExecute(Boolean result) {
     Toast.makeText(getApplicationContext(), "Value =="+result, Toast.LENGTH_LONG).show();
 }
}