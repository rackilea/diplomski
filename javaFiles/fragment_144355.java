public class MyApplication extends ResourceConfig {
    public MyApplication() {
        ...
        register(TestFilter.class, 6000);
        register(TestFilter2.class, 6001);*/
    }
}