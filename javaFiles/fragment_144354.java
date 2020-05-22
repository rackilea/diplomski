@ApplicationPath("/")
public class MyApplication extends Application {
    public MyApplication(@Context Configurable configurable) {
        configurable.register(MyFilter1.class, 1000);
        configurable.register(MyFilter2.class, 1001);
    }
}