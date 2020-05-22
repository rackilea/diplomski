class MyApp extends Application {

static Context mContext = null;

public void onCreate() {
    mContext = getApplicationContext();
    objecofYourLibClass = new MyApp();
    objecofYourLibClass.yourMethod(mContext);
}

}