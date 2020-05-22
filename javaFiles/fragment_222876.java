/**
 * Retrieves the naming context bound to a class loader.
 */
public static Context getClassLoader()
    throws NamingException {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    Context context = null;
    do {
        context = clBindings.get(cl);
        if (context != null) {
            return context;
        }
    } while ((cl = cl.getParent()) != null);
    throw new NamingException
        (sm.getString("contextBindings.noContextBoundToCL"));
}