public class A<V extends A.B> {

    static class B extends A<V> {       
    }

    @Inject
    A<V> s2; 
}