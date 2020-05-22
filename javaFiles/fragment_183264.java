File file = new File("path to your file");
File dir = file.getParentFile();
URL url = new URL("file://" + dir.getAbsolutePath());
URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
Class<?> clazz = classLoader.findClass("ClassName");
JUnitCore.runClasses(clazz);