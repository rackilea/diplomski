URL url = MyClass.class.getResource("MyClass.class");
String scheme = url.getProtocol();
if (!"jar".equals(scheme))
  throw new IllegalArgumentException("Unsupported scheme: " + scheme);
JarURLConnection con = (JarURLConnection) url.openConnection();
JarFile archive = con.getJarFile();
/* Search for the entries you care about. */
Enumeration<JarEntry> entries = archive.entries();
while (entries.hasMoreElements()) {
  JarEntry entry = entries.nextElement();
  if (entry.getName().startsWith("com/y/app/")) {
    ...
  }
}