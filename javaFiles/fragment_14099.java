intent.addFlags (FLAG_ACTIVITY_SINGLE_TOP);

...


class HomeActivity extends Activity {
   ...
   @Override
   protected void onNewIntent(Intent intent) {
      Bundle extras = intent.getExtras();
   }
   ...
}