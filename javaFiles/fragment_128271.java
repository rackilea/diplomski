try {
    File file = new File(".");
    URL url = file.toURL();
    URL[] urls = new URL[] { url };
    ClassLoader cl = new URLClassLoader(urls);
    Class c = cl.loadClass("design.pattern.Person");
    System.out.println(c.isInterface());
}
catch (Exception e) {
    e.printStackTrace();
}