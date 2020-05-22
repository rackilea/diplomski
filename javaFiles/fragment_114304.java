private static class ByteClassLoader extends ClassLoader{
    private Map<String, JavaFileObject> store = new HashMap<String, JavaFileObject>();
    public ByteClassLoader(Map<String, JavaFileObject> str)
     {
     super( ByteClassLoader.class.getClassLoader() ); // set parent
     store = str;
    }

    protected Class<?> findClass(String name)
            throws ClassNotFoundException{
        JavaFileObject jfo = store.get(name);
        if (jfo == null){
            throw new ClassNotFoundException(name);
        }

        byte[] bytes = ((JavaClassObject)jfo).getBytes();
        Class<?> cl = defineClass(name, bytes, 0, bytes.length);
        if (cl == null){
            throw new ClassNotFoundException(name);
        }
        return cl;
    }
}