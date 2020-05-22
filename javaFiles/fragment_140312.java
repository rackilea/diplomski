interface AsyncTaskListener{
     public void onTaskCompleted(Object<Type> value);
  }

  public class DemoAsyncTask extends AsyncTask<String,Void,Void>{
  AsyncTaskListener listener;
  public  DemoAsyncTask(AsyncTaskListener listener){
        this.listener = listener;
  }
  @Override
  protected String doInBackground(Void... params) {
   ///do some task 
    return someResult;
  }
  @Override
  protected void onPostExecute(String result) {
   listener.onTaskCompleted(result);
  }