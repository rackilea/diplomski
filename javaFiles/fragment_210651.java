try (java.io.InputStream in = MyProperties.class.getClassLoader().
            getResourceAsStream("application.properties")) {
    // load properties
} catch (Exception e) {
    e.printStackTrace();
}