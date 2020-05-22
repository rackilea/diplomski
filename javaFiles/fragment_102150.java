public class MyTask extends AsyncTask<..., ..., MyClass> {
  private MyTaskHandler myTaskHandler;

  public MyTask(MyTaskHandler myTaskHandler) { 
    this.myTaskHandler = myTaskHandler;
  }

  @Override
  public void onPostExecute(MyClass[] results) {
    myTaskHandler.onComplete(results);
  }
}