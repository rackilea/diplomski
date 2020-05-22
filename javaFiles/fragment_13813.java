public java.io.InputStream loadByName(String name) {
  java.io.File f = new java.io.File(name);
  if (f.isFile()) {
    return new FileInputStream(f);
  } else {
    return getClass().getResource(name);
  }
}