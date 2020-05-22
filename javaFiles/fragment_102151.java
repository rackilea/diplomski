public class MyActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    new MyAsyncTask(new MyTaskHandler() {
      @Override
      public void onComplete(MyClass[] results) {
        // load into list view
      }
    }).execute();

    new MyAsyncTask(new MyTaskHandler() {
      @Override
      public void onComplete(MyClass[] results) {
        // load into tabs
      }
    }).execute();
  }
}