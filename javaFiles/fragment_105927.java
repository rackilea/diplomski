@ApplicationPath("/services")
public class QuestionApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(QuestionWebService.class);
        return classes;
    }
}