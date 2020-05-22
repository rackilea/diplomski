String result = "";

    ClassLoader classLoader = getClass().getClassLoader();
    try {
        result = IOUtils.toString(classLoader.getResourceAsStream("fileName"));
    } catch (IOException e) {
        e.printStackTrace();
    }