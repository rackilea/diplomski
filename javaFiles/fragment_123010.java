private void invokeClass(String path, String name, String[] args) throws
        ClassNotFoundException,
        NoSuchMethodException,
        InvocationTargetException,
        MalformedURLException,
        InterruptedException,
        IllegalAccessException {
    File f = new File(path);
    URLClassLoader u = new URLClassLoader(new URL[]{f.toURI().toURL()});
    Class c = u.loadClass(name);
    Method m = c.getMethod("main", new Class[]{args.getClass()});
    m.setAccessible(true);
    int mods = m.getModifiers();
    if (m.getReturnType() != void.class || !Modifier.isStatic(mods) || !Modifier.isPublic(mods)) {
        throw new NoSuchMethodException("main");
    }
    m.invoke(null, new Object[]{args});
    m = null;
    System.gc(); // uh-oh
}