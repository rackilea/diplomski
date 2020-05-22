class TheTask extends AsyncTask<Void,Void,Void>
{
          protected void onPreExecute()
          {           super.onPreExecute();
                    //display progressdialog.
          } 

           protected void doInBackground(Void ...params)
          {  
                //http request. do not update ui here

                return null;
          } 

           protected void onPostExecute(Void result)
          {     
                    super.onPostExecute(result);
                    //dismiss progressdialog.
                    //update ui
          } 

}