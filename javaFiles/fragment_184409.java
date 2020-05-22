class RestrictingClassLoader extends URLClassLoader {
  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
    if (!name.startsWith("com.example.") || name.startsWith("com.example.api."))
      return super.loadClass(name);
    return findClass(name);
  }
}

class RestrictingSecurityManager extends SecurityManager {
  private boolean isRestricted() {
    for (Class<?> cls: getClassContext())
      if (cls.getClassLoader() instanceof RestrictingClassLoader)
        return true;
    return false;
  }
  // Implement other checks based on isRestricted().
}