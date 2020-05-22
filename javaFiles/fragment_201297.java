public class MyApplicationInstance extends MultiDexApplication {

    private static MyApplicationInstance instanceApplication;

    private String dsChaveAcessoWbs;
    private Tracker mTracker;

    /**
     * Verificação de instancia devido uso da camera
     */
    public MyApplicationInstance() {

        if (instanceApplication == null) {
            instanceApplication = this;
        }
    }

    public static MyApplicationInstance getInstanceApplicationSingleton() {

        return instanceApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
...
}