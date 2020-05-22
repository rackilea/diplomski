private static volatile LoadingCache<String, MyClass> cache = null;
public MyClass method(final String id1, final long id2)  {
    ...
    if(cache == null){
        synchronized (MyClass.class) {
            if(cache == null){
                cache = ...
            }
        }
    }