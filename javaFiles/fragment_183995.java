public class App extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context get() {
        return context;
    }
}