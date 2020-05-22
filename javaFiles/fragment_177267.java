getClassPath()
{
  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
  URL[] urls = ((URLClassLoader) classLoader).getURLs();
  StringBuilder buf = new StringBuilder(1000);
  buf.append(".");
  String separator = System.getProperty("path.separator");
  for (URL url : urls) {
      buf.append(separator).append(url.getFile());
  }
}

classPath = buf.toString();