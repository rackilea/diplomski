public class YourExtension implements Extension {

    <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {
        if(pat.getAnnotatedType().isAnnotationPresent(FXMLManaged.class)) {
            // do your stuff here
        }
    } 
}