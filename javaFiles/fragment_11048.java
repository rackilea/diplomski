public void onClick(View v)
{
    // Get user defined values
    Name = fname.getText().toString();
    Email = email.getText().toString();
    Login = login.getText().toString();
    Pass = pass.getText().toString();

    new AsyncTask<Void, Void, String>()
    {
         @Override
         public String doInBackground (Void... params)
         {
             return GetText();
         }

         @Override
         protected void onPostExecute(String result)
         {
             content.setText(result);
         }

    }.execute();
}