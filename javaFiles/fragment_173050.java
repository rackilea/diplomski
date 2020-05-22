final Properties properties = ...;
for (final String name : properties.stringPropertyNames()) {
  if (name.startsWith("prefix.")) {
    properties.setProperty(name.substring(6, name.length()), properties.remove(name));
  }
}