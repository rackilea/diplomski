public static class ByteClassLoader extends URLClassLoader {
    private final Map<String, byte[]> extraClassDefs;

    public ByteClassLoader(URL[] urls, ClassLoader parent, Map<String, byte[]> extraClassDefs) {
      super(urls, parent);
      this.extraClassDefs = new HashMap<String, byte[]>(extraClassDefs);
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
      byte[] classBytes = this.extraClassDefs.remove(name);
      if (classBytes != null) {
        return defineClass(name, classBytes, 0, classBytes.length); 
      }
      return super.findClass(name);
    }

  }