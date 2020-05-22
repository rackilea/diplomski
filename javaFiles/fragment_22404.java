public class JwsUrlFixerClassLoader extends URLClassLoader {

    private final static Logger LOG = Logger.getLogger(JwsUrlFixerClassLoader.class);

    private static String SIMPLE_CLASS_NAME = null;

    private static boolean LOG_ENABLED = "true".equals(System.getProperty("classloader.debug"));

    static {
        SIMPLE_CLASS_NAME = JwsUrlFixerClassLoader.class.getName();
        int idx = SIMPLE_CLASS_NAME.lastIndexOf('.');
        if (idx >= 0 && idx < SIMPLE_CLASS_NAME.length()-1) {
            SIMPLE_CLASS_NAME = SIMPLE_CLASS_NAME.substring(idx + 1);
        }
    }

    public JwsUrlFixerClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public URL getResource(String name) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getResource(): getResource(" + name + ")");
        }
        if (LOG_ENABLED) {
            login("getResource(" + name + ")");
        }
        URL out = super.getResource(name);
        if (out != null) {
            out = URLFixerTool.fixUrl(out);
        }
        if (LOG_ENABLED) {
            logout("getResource returning " + out);
        }
        return out;
    }

    public URL findResource(String name) {
        if (LOG_ENABLED) {
            login("findResource(" + name + ")");
        }
        URL out = super.findResource(name);
        if (out != null) {
            out = URLFixerTool.fixUrl(out);
        }
        if (LOG_ENABLED) {
            logout("findResource returning " + out);
        }
        return out;
    }

    public InputStream getResourceAsStream(String name) {
        if (LOG_ENABLED) {
            login("getResourceAsStream(" + name + ")");
        }
        InputStream out = super.getResourceAsStream(name);
        if (LOG_ENABLED) {
            logout("getResourceAsStream returning " + out);
        }
        return out;
    }

    protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (LOG_ENABLED) {
            login("loadClass(" + name + ")");
        }
        // First, check if the class has already been loaded
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = findClass(name);
            } catch (ClassNotFoundException cnfe) {
                if (getParent() == null) {
                    // c = findBootstrapClass0(name);
                    Method m = null;
                    try {
                        m = URLClassLoader.class.getMethod("findBootstrapClass0", new Class[] {});
                        m.setAccessible(true);
                        c = (Class) m.invoke(this, new Object[] { name });
                    } catch (Exception e) {
                        throw new ClassNotFoundException();
                    }
                } else {
                    c = getParent().loadClass(name);
                }
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        if (LOG_ENABLED) {
            logout("loadClass returning " + c);
        }
        return c;
    }

    private static void login(String message) {
        System.out.println("---> [" + Thread.currentThread().getName() + "] " + SIMPLE_CLASS_NAME + ": " + message);
    }

    private static void logout(String message) {
        System.out.println("<--- [" + Thread.currentThread().getName() + "] " + SIMPLE_CLASS_NAME + ": " + message);
    }

}