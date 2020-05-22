Enumeration<URL> resources = getClass().getClassLoader()
  .getResources("META-INF/MANIFEST.MF");
while (resources.hasMoreElements()) {
    try {
      Manifest manifest = new Manifest(resources.nextElement().openStream());
      // check that this is your manifest and do what you need or get the next one
      ...
    } catch (IOException E) {
      // handle
    }
}