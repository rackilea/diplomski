public class ActivityHelper { 
  // Declarations

  @Override
   public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
    // Some code
  }

  @Override
  protected void onPause(activity) {
    // Some code
   }

   protected void initializeMenu(activity) {
    // Init


   }
}

public class MyActivity extends Activity { 
  private final ActivityHelper helper;

  @Override
   public boolean onCreateOptionsMenu(Menu menu) {
    helper.onCreateOptionsMenu(this, menu)
  }

  @Override
  protected void onPause() {
    helper.onPause(this);
  }

   protected void initializeMenu() {
     helper.initializeMenu(this)
   }
}