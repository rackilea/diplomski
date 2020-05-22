@ApplicationPath("/")
public class RestApplication extends Application {

    @Override
    public Set<Object> getSingletons() {
        HashSet<Object> singletons = new HashSet<>();
        singletons.add(new SecurityInterceptor());
        return singletons;
    }

}