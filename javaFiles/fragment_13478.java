public class BaseActivity extends Activity {

   public void onResume() {
      MyBaseApplicationType app = (MyBaseApplicationType)getApplicationContext();
      app.incrementForegroundActivity();
   }

   public void onPause() {
      MyBaseApplicationType app = (MyBaseApplicationType)getApplicationContext();
      app.decrementForegroundActivity();
   }

}