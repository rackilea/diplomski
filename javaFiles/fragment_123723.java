public String getModelFromStream(String fileName) {
    final String classpath = "resourcez/";
    ClassLoader classLoader = DexiModelLoader.class.getClassLoader();
    InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

    if (resourceAsStream == null)
        resourceAsStream = classLoader.getResourceAsStream(classpath + fileName);

    if (resourceAsStream == null)
        return "error";

    Scanner s = new Scanner(resourceAsStream).useDelimiter("\\A");
    return s.hasNext() ? s.next() : "";
}