public class MyApplication  extends Application {
private Set<Object> singletons = new HashSet<Object>();

public MyApplication() {
    singletons.add(new RestEasyExample());
    singletons.add(new RestEasyExample2());
}

@Override
public Set<Class<?>> getClasses() {
    // TODO Auto-generated method stub
    return null;
}
@Override
public Set<Object> getSingletons() {
    return singletons;
}
}