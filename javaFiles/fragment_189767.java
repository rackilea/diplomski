public class AppData extends Application {

    public static AppData appData;

    public int currentUserId; // etc.

    //Const.
    public AppData() {
        appData = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loginPreferences = getSharedPreferences(
            SPF_NAME, 0);

        pathToSDCard = Environment.getExternalStorageDirectory().getAbsolutePath();
        System.out.println("Path : " + pathToSDCard);
       //etc.
    }

 //    MOST IMP  FOR GETTIN SINGELTON INSTANCE     <<<---<<<---<<<---
    public static AppData getAppData() {
        return appData;
    }
}