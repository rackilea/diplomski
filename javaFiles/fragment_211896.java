@Provider
public class MyObjectProvider extends SingletonTypeInjectableProvider<Context, MyObject> {
    public MyObjectProvider() {
        // binds MyObject.class to a single MyObject instance
        // i.e. the instance of MyObject created bellow will be injected if you use
        // @Context MyObject myObject
        super(MyObject.class, new MyObject());
    }
}