public URL getResource(final String name) {
  try {
    return new URL("", "", 0, "",
        new URLStreamHandler() { public URLConnection openConnection(URL url) {
          return new URLConnection(url) {
            public void connect() {}
            public InputStream getInputStream() {
              // return the appropriate InputStream, based on the name arg
            }
          };
        }});
  } catch (MalformedURLException e) { throw new RuntimeException(e); }
}