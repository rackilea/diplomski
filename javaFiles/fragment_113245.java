class MyApp extends Application {
private static MyApp mInstance;

void onCreate() {
   mInstance = this;
}

public Context context() { return mInstance.getApplicationContext(); }

}