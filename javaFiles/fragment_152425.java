CodeSource src = MyClass.class.getProtectionDomain().getCodeSource();
if (src != null) {
  URL jar = src.getLocation();
  ZipInputStream zip = new ZipInputStream(jar.openStream());
  /* Now examine the ZIP file entries to find those you care about. */
  ...
} 
else {
  /* Fail... */
}