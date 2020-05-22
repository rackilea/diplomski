URL classesURL = new URL("file://" + outputDir.getAbsolutePath() + "/");
// The current class loader serves as the parent class loader for the custom one.
// Obviously, it won’t find the compiled class.
URLClassLoader customCL = URLClassLoader.newInstance(new URL[]{classesURL}, classLoader);

Class<?> annotatedClass = customCL.loadClass(element.getQualifiedName().toString());