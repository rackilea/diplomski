public class ByteClassLoader extends ClassLoader {
    private final byte[] jarBytes;

    public ByteClassLoader(ClassLoader parent, byte[] jarBytes) throws IOException {
        super(parent);
        this.jarBytes = jarBytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        // read byte array with JarInputStream
        try (JarInputStream jis = new JarInputStream(new ByteArrayInputStream(jarBytes))) {
            JarEntry nextJarEntry;

            // finding JarEntry will "move" JarInputStream at the begining of entry, so no need to create new input stream
            while ((nextJarEntry = jis.getNextJarEntry()) != null) {

                if (entryNameEqualsClassName(name, nextJarEntry)) {

                    // we need to know length of class to know how many bytes we should read
                    int classSize = (int) nextJarEntry.getSize();

                    // our buffer for class bytes
                    byte[] nextClass = new byte[classSize];

                    // actual reading
                    jis.read(nextClass, 0, classSize);

                    // create class from bytes
                    return defineClass(name, nextClass, 0, classSize, null);
                }
            }
            throw new ClassNotFoundException(String.format("Cannot find %s class", name));
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot read from jar input stream", e);
        }
    }


    private boolean entryNameEqualsClassName(String name, JarEntry nextJarEntry) {

        // removing .class suffix
        String entryName = nextJarEntry.getName().split("\\.")[0];

        // "convert" fully qualified name into path
        String className = name.replace(".", "/");

        return entryName.equals(className);
    }
}