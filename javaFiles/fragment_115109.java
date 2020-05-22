protected synchronized Class<?> loadClass(String name, boolean resolve) {
  // First, check if this class loader has directly defined the class or if the
  // JVM has initiated the class load with this class loader.
  Class<?> result = findLoadedClass(name);
  if (result == null) {
    try {
      // Next, delegate to the parent.
      result = getParent().loadClass(name);
    } catch (ClassNotFoundException ex) {
      // Finally, search locally if the parent could not find the class.
      result = findClass(ex);
    }
  }
  // As a remnant of J2SE 1.0.2, link the class if a subclass of the class
  // loader class requested it (the JVM never calls the method,
  // loadClass(String) passes false, and the protected access modifier prevents
  // callers from passing true).
  if (resolve) {
    resolveClass(result);
  }
  return result;
}