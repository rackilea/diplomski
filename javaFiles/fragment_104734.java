public class AppAplication extends Application {
   @Override
   public void onCreate() {
      super.onCreate();

      ParseObject.registerSubclass(AlertObject.class);
      Parse.enableLocalDatastore(this);
      Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
  }
}