public static Serializable readObject(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
    return readObject(path, null);
}

public static Serializable readObject(String path, final ClassLoader classLoader) throws FileNotFoundException, IOException, ClassNotFoundException {
    Serializable obj;
    try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis) {

        @Override
        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
            if (classLoader == null) {
                return super.resolveClass(desc);
            }
            return Class.forName(desc.getName(), false, classLoader);
        }

    }) {
        obj = (Serializable) ois.readObject();
    }
    return obj;
}