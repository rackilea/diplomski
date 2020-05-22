AsyncTask<Void, Void, Void> aTask = new AsyncTask<Void,Void,Void>()
    {
      @Override
      protected void onPreExecute()
    {
       //task to run before main network operations start
    }
      @Override
      protected void doInBackground(Void ... s )
     {
        //all the operations to perform should go here
      }

     @Override
     protected void onPostExecute()
     {
       //called when operations have finished and the onBackgroun
     }
    }