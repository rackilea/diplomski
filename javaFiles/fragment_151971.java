public class ModifiableClassLoader extends ClassLoader {

    private final Map<String, byte[]> definitions;

    public ModifiableClassLoader(JarFile jar, Map<String, byte[]> definitions) throws MalformedURLException {
        super(new URLClassLoader(new URL[] { new URL("jar:" + new File(jar.getName()).toURI().toURL() + "!/") }));
        this.definitions = definitions;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = definitions.remove(name);
        if (classBytes != null) {
            return defineClass(name, classBytes, 0, classBytes.length);
        }
        return super.findClass(name);
    }
}