public class Base {

    private final ICacheHelper cachehelper;

    public Base(ICacheHelper cachehelper) {
        this.cachehelper = cachehelper;
    }

    public <T> ResponseEntity<T> simpleResponse(T object, CacheControl cacheControl) {
         // ...
    }

    public <A> ResponseEntity<A> anotherSimpleResponse(A object, CacheControl cacheControl) {
        // ...
    }
}