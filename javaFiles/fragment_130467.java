public class GlobalClass extends Application {
    public static GlobalClass instance;
    public void onCreate() {
        instance = getApplication();
    }
}