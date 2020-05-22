@ApplicationPath("/")
public class RESTConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(CORSFilter.class);

        // wrong
        //set.add(super.getClass());
        //return super.getClasses();

        // corrected
       set.addAll(super.getClasses());
       return set;
    }    
}