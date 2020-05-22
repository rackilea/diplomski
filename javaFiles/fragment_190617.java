public class ConstraintClassLoader extends URLClassLoader {

public ConstraintClassLoader(URL[] urls, ClassLoader parent) {
    super(urls, parent);
}

@Override
protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
    synchronized (getClassLoadingLock(name)) {
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = findClass(name);
            } catch (ClassNotFoundException e) {
                c = super.loadClass(name, resolve);
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }
}

@Override
protected Class<?> findClass(String name) throws ClassNotFoundException {
    try {
        System.out.println("find " + name);
        Class<?> c = super.findClass(name);
        Class<?> parent = c.getSuperclass();
        while (parent != null)  {
            if (parent.getName().contains("X")) {
                break;
            }
            parent = parent.getSuperclass();
        }
        if (parent == null) {
            return c;
        }
        Field declaredField = c.getDeclaredField("a");
        declaredField.setAccessible(true);
        if (declaredField.get(null) == null) {
            throw new AssertionError();
        }
        return c;
    } catch (NullPointerException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | AssertionError e) {
        throw new RuntimeException(e);
    }
}
}