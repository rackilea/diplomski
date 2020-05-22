package my.app.package;  // This should match the package path in your Manifest

public class MyApp extends android.app.Application { // This should match the app name in your manifest

    private static MyApp appContext;

    public MyApp() { appContext = this; }

    public static Context getAppContext() { return appContext; }

}