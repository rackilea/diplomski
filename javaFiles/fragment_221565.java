public class DashboardActivity extends Activity {

   public static String USER_FUNCTIONS = "user functions";
   private static String KEY_SUCCESS = "success";

   /**
    * Millisecondes
    */
   private static int POLLING_WAITING_TIME = 5 * 1000;
   UserFunctions mUserFunctions;
   Button btnLogout;
   Button btnloc;
   GPSTracker gps;

   private Handler mHandler;
   private Runnable mRunnable;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.dashboard);

      Bundle extras = getIntent().getExtras();
      if (extras != null) {
         if (extras.containsKey(USER_FUNCTIONS)) {
            mUserFunctions = (UserFunctions) extras.getSerializable(USER_FUNCTIONS);
         }
      }
      toggleActivities();
   }

   @Override
   protected void onResume() {
      super.onResume();
      toggleActivities();
   }

   /**
    * 
    */
   private void toggleActivities() {
      // Check login status in database
      if (mUserFunctions != null && mUserFunctions.isUserLoggedIn(getApplicationContext())) {
         // user already logged in show databoard

         btnLogout = (Button) findViewById(R.id.btnLogout);
         btnLogout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
               // TODO Auto-generated method stub
               mUserFunctions.logoutUser(getApplicationContext());
               Intent login = new Intent(getApplicationContext(), LoginActivity.class);
               login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(login);
               // Closing dashboard screen
               finish();
            }
         });

      } else {
         // user is not logged in show login screen
         Intent login = new Intent(getApplicationContext(), LoginActivity.class);
         login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         startActivity(login);
         // Closing dashboard screen
         finish();
      }
      // startTimer
      timer();
   }

   /**
    * managed HandlerManger and controls the timer
    */
   private void timer() {
      mRunnable = new HandlerManger();
      mHandler = new Handler();
      mHandler.postDelayed(mRunnable, POLLING_WAITING_TIME);
   }

   /**
    * 
    */
   private void processGPSTracker() {
      if (mUserFunctions == null || !mUserFunctions.isUserLoggedIn(getApplicationContext()))
         return;

      gps = new GPSTracker(DashboardActivity.this);
      if (gps.canGetLocation()) {

         double latitude = gps.getLatitude();
         double longitude = gps.getLongitude();

         JSONObject json = mUserFunctions.updateUserGeoLocation(Double.valueOf(longitude)
               .toString(), Double.valueOf(latitude).toString());

         // check for login response
         try {
            if (json.getString(KEY_SUCCESS) != null && json.getString(KEY_SUCCESS).equals("1")) {
               Log.i("DashboardActivity", "Update on geolocation success");
            } else {
               Log.e("DashboardActivity", "Update on geolocation Failed");
            }
         } catch (JSONException e) {
            e.printStackTrace();
         }

         // \n is for new line
         Toast.makeText(getApplicationContext(),
               "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG)
               .show();

      } else {
         // can't get location
         // GPS or Network is not enabled
         // Ask user to enable GPS/network in settings
         gps.showSettingsAlert();
      }
   }

   /**
    * Timer business logic runner
    * 
    * @author Festus Tamakloe
    */
   private class HandlerManger implements Runnable {

      public void run() {
         processGPSTracker();
      }

   }
}