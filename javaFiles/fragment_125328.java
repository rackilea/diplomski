public class App extends Application {

        @Override
        public void onCreate() {
            super.onCreate();
            AppPreferences.init(this);
        }
    }