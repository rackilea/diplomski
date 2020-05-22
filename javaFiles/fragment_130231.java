public class AndroidLauncher implements SomeInterface{

        @Override
        protected void onCreate() {    

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new MyGdxGame(this), config);

    }

        public void walo() {
          Toast.makeText(getApplicationContext(), "You Don't Have Enough Money",
          Toast.LENGTH_LONG).show();
    }
    }