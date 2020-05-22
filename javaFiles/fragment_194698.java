public class MyApp extends Application {
     public void onCreate() {
          super.onCreate();
     }

     private Activity mCurrentActivity = null;
     public Activity getCurrentActivity(){
          return mCurrentActivity;
     }
     public void setCurrentActivity(Activity mCurrentActivity){
          this.mCurrentActivity = mCurrentActivity;
     }
}