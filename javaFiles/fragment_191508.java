// Get the URL of my jar file
URL url = MyClass.class.getResource("/dependencies/dependency.jar");
// Create my temporary file
Path path = Files.createTempFile("dependency", "jar");
// Delete the file on exit
path.toFile().deleteOnExit();
// Copy the content of my jar into the temporary file
try (InputStream is = url.openStream()) {
    Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
}
// Create my CL with this new URL
URLClassLoader myCL = new URLClassLoader(
    new URL[]{path.toUri().toURL()}, ClassLoader.getSystemClassLoader().getParent()
);