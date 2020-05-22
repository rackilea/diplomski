// Create a new custom class loader, pointing to the directory that contains the compiled
// classes, this should point to the top of the package structure!
URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
// Load the class from the classloader by name....
Class<?> loadedClass = classLoader.loadClass("testcompile.HelloWorld");
// Create a new instance...
Object obj = loadedClass.newInstance();
// Santity check
if (obj instanceof DoStuff) {
    // Cast to the DoStuff interface
    DoStuff stuffToDo = (DoStuff)obj;
    // Run it baby
    stuffToDo.doStuff();
}