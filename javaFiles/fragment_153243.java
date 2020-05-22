static X s_x = new X(getClassStatic());

public static Class<?> getClassStatic() {
    try {
        // we're using the third highest stack element, since the
        // first highest is the getStackTrace() method, followed by this method itself. We
        // want the calling code's class.
        String name = Thread.currentThread().getStackTrace()[2].getClassName();
        return Class.forName(name);
    } catch (ClassNotFoundException e) {
        // shouldn't be able to get here...
        return null;
    }
}