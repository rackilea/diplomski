public class AppSingleton extends Application {

public static AppSingleton appSingleton;

public AppSingleton() {}

@Override
public void onCreate() {
    super.onCreate();
    appSingleton = this;

}

public static AppSingleton getContext() {
    return sapronApplication;
}}