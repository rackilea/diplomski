ClassLoader classLoader = getClass().getClassLoader();
if (classLoader.getResourceAsStream(filePath) == null) {
    // throw error
}
InputStream inputStream = classLoader.getResourceAsStream(filePath);
// write input stream to a file