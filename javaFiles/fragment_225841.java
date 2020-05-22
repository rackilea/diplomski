public class MagicClassLoader extends ClassLoader {

    private final String defaultPackageName;

    public MagicClassLoader(String defaultPackageName) {
        super();
        this.defaultPackageName = defaultPackageName;
    }

    public MagicClassLoader(String defaultPackageName, ClassLoader parent) {
        super(parent);
        this.defaultPackageName = defaultPackageName;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] bytecode = ...; // I will leave this part up to you
        byte[] remappedBytecode;

        try {
            remappedBytecode = rewriteDefaultPackageClassNames(bytecode);
        } catch (IOException e) {
            throw new RuntimeException("Could not rewrite class " + name);
        }

        return defineClass(name, remappedBytecode, 0, remappedBytecode.length);
    }

    public byte[] rewriteDefaultPackageClassNames(byte[] bytecode) throws IOException {
        ClassReader classReader = new ClassReader(bytecode);
        ClassWriter classWriter = new ClassWriter(classReader, 0);

        Remapper remapper = new DefaultPackageClassNameRemapper();
        classReader.accept(
                new RemappingClassAdapter(classWriter, remapper),
                0
            );

        return classWriter.toByteArray();
    }

    class DefaultPackageClassNameRemapper extends Remapper {

        @Override
        public String map(String typeName) {
            boolean hasPackageName = typeName.indexOf('.') != -1;
            if (hasPackageName) {
                return typeName;
            } else {
                return defaultPackageName + "." + typeName;
            }
        }

    }

}