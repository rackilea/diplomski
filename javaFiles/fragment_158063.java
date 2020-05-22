public class App extends Application {

    public void onCreate() {
        super.onCreate()
        Instance = this;
        AndroidUtilities.init();

        // your other code
    }
}