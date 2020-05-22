public class MyBaseApplication extends Application {

   private int mForegroundActivities;
   private Handler mHandler;

   public void onCreate() {
      mHandler = new Handler();
   }

   public void decrementForegroundActivity() {
      mForegroundActivities--;
      if (mForegroundActivities == 0) {
         mHandler.postDelayed(mRunnable, 1000 /*about a second*/);
      }
   }

   public void incrementForegroundActivities() {
      mForegroundActivities++;
   }

   private Runnable mRunnable = new Runnable() {
      public void run() {
         if (mForegroundActivities == 0) {
            // Listeners of this broadcast can then clean up anything
            // as needed.
            Intent intent = new Intent("com.my.package.ACTION_BACKGROUNDED");
            sendBroadcast(intent);
         }
      }
   };

}