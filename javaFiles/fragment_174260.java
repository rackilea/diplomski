Properties properties = new Properties();
properties.putAll(yourMap); // You could also just use Properties in first place.

try (OutputStream output = new FileOutputStream("/foo.properties")) {
    properties.store(output, null);
}