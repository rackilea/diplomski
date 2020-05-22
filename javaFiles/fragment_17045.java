interface Acquire<R, EXC extends Exception> {
    R acquire() throws EXC;
}
// Effectively the same as Use, but different.
interface Release<R, EXC extends Exception> {
    void release(R resource) throws EXC;
}

public static <R, EXC extends Exception> R returnResource(
    Acquire<R, EXC> acquire, Release<R, EXC> release, Use<R, EXC> initialize
) throws EXC {
    try (var adapter = new AutoCloseable() { // anonymous classes still define type
        private R resource = acquire.acquire();
        R get() {
            return resource;
        }
        void success() {
            resource = null;;
        }
        public void close() throws EXC {
           if (resource != null) {
               release.release(resource);
           }
        }
    }) {
        R resource = adapter.get();
        initialize.use(resource);
        adapter.success();
        return resource;
    }
}