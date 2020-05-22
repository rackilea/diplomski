/** Run with -Djava.system.class.loader=MyLoader to use this class loader. */
public static class MyLoader extends URLClassLoader {
    public MyLoader(ClassLoader launcherClassLoader) {
        super(getUrls(launcherClassLoader), launcherClassLoader.getParent());
    }

    private static URL[] getUrls(ClassLoader cl) {
        System.out.println("---MyLoader--- inside #constructor(" + cl + ")...");
        return ((URLClassLoader) cl).getURLs();
    }

    @Override public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("---MyLoader--- inside loadClass(" + name + ", " + resolve + ")...");
        return super.loadClass(name, resolve);
    }
}