public class SampleApplication extends Application {
    private static SampleApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static SampleApplication instance() {
        return INSTANCE;
    }
}