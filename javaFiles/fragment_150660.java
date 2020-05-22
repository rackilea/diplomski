public class TestMyApplication extends MyApplication
        implements TestLifecycleApplication {

    private SharedService sharedService;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override public void beforeTest(Method method) {
    }

    @Override public void prepareTest(Object test) {
    }

    @Override public void afterTest(Method method) {
    }

    @Override public CPSharedService getCPSharedService() {
        return this.sharedService;
    }

    public void setCPSharedService(SharedService sharedService) {
        // store your mock
        this.sharedService = sharedService;
    }
}