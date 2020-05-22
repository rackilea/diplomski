public class Test {
  private static final String absName = "/yourpackage/yourimage.jpg";

  public static void main(String[] args) {
    Class c=null;
    try {
      c = Class.forName("yourpackage.Test");//pkg is the package name in which the resource lies
    } catch (Exception ex) {
      // This should not happen.
    }
    InputStream s = c.getResourceAsStream(absName);
    // do something with it.
  }

    public InputStream getResourceAsStream(String name) {
      name = resolveName(name);
      ClassLoader cl = getClassLoader();
      if (cl==null) {
        return ClassLoader.getSystemResourceAsStream(name); // A system class.
      }
      return cl.getResourceAsStream(name);
    }

    public java.net.URL getResource(String name) {
      name = resolveName(name);
      ClassLoader cl = getClassLoader();
      if (cl==null) {
        return ClassLoader.getSystemResource(name);  // A system class.
      }
      return cl.getResource(name);
    }

    private String resolveName(String name) {
      if (name == null) {
        return name;
      }
      if (!name.startsWith("/")) {
        Class c = this;
        while (c.isArray()) {
          c = c.getComponentType();
        }
        String baseName = c.getName();
        int index = baseName.lastIndexOf('.');
        if (index != -1) {
          name = baseName.substring(0, index).replace('.', '/') + "/" + name;
        }
      } else {
        name = name.substring(1);
      }
      return name;
    }
}