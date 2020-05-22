Closeable c = (Closeable) java.lang.reflect.Proxy.newProxyInstance(
    getClass().getClassLoader(),
    new Class[]{ Closeable.class },
    new MyHandler(obj));

// works! by MyHandler is called instead.
c.close();