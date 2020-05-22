URLClassLoader cl = (URLClassLoader) getClass().getClassLoader();
try {
  URL url = cl.findResource("META-INF/MANIFEST.MF");
  Manifest manifest = new Manifest(url.openStream());
  // do stuff with it
  ...
} catch (IOException E) {
  // handle
}