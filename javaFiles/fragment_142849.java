public class MyApplication extends Application {
@Override
    public void onCreate() {
        super.onCreate();
        appInitialization();
    }

    private void appInitialization() {
         defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
         Thread.setDefaultUncaughtExceptionHandler(_unCaughtExceptionHandler);
    }

    private UncaughtExceptionHandler defaultUEH;

    // handler listener
    private Thread.UncaughtExceptionHandler _unCaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            ex.printStackTrace();
            // TODO handle exception here
        }
    };
}