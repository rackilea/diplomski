private static final String NAME = "my.properties";

private static final Properties config;

static {
  Properties fallback = new Properties();
  fallback.put("key", "default");
  config = new Properties(fallback);

  URL res = MyClass.getResource(NAME);
  if (res == null) throw new UncheckedIOException(new FileNotFoundException(NAME));
  URI uri;
  try { uri = res.toURI(); }
  catch (URISyntaxException ex) { throw new IllegalArgumentException(ex); }

  try (InputStream is = Files.newInputStream(Paths.get(uri))) { config.load(is); } 
  catch (IOException ex) { throw new UncheckedIOException("Failed to load resource", ex); }
}