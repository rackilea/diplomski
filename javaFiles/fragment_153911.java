public class MyTestApplication extends MyApplication {
    @Override
    public void onCreate() {
        MyApplication.instance = this;
    }
}