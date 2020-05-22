Properties properties = new Properties();

try (InputStream input = new FileInputStream("/foo.properties")) {
    properties.load(input);
}

// ... (Properties implements Map, you could just treat it like a Map)