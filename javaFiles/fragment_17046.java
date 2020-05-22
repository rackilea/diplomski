public static InputStream newThing(String name) throws IOException {
    return returnResource(
        name,
        FileInputStream::new,
        InputStream::close,
        in -> {
            int ignore = in.read(); // some work
        }
    );
}

// Like Function, but with a more descriptive name for a functional interface.
interface AcquireFrom<T, R, EXC extends Exception> {
    R acquire(T t) throws EXC;
}

public static <T, R, EXC extends Exception> R returnResource(
    T t, AcquireFrom<T, R, EXC> acquire, Release<R, EXC> release, Use<R, EXC> initialize
 ) throws EXC {
     return returnResource(() -> acquire.acquire(t), release, initialize);
 }