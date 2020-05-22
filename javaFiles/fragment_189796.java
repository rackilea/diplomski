Path jar = Paths.get("/home/duke/duke.jar");

    try {
        ClassLoader classLoader = new URLClassLoader(
            new URL[] { jar.toUri().toURL() });

        Class<?> mainClass = Class.forName("com.foo.Main", true, classLoader);
        mainClass.getMethod("main", String[].class).invoke(null, new String[0]);
    } catch (ReflectiveOperationException | MalformedURLException e) {
        throw new RuntimeException("Could not run " + jar, e);
    }