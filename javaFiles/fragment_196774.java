//create a object f your asyncclass and 
//override the onPostExecute where you need it
mInfo = new ASYNCCLASS({
   @Override
   public void onPostExecute(Object result){
      //doSomething
      Log.e(...);
  }
}).execute();