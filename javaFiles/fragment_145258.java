@Name
public class Service {

    @In
    private MyAnnotatedClass myAnnotatedClass;


    public void myInterceptedMethod() {
        // internal method bypass interceptor
        // So @In or @Out-jection is not enabled
        internalMethod();
    }

    private void internalMethod() {
        System.out.println(myAnnotatedClass.getClass().getAnnotation(annotationClass));
    }

}