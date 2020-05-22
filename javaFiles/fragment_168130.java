File file = new File("/path/to/myapp.jar");    
JarFile jarFile = new JarFile(file);  
Manifest manifest = jarFile.getManifest();
if (manifest != null) {
    Attributes attributes = manifest.getMainAttributes();  
    String className = attributes.getValue(Attributes.Name.MAIN_CLASS);
    URLClassLoader loader = new URLClassLoader(new URL[] { file.toURI().toURL() }); 
    Class<?> cls = loader.loadClass(className);
    Method main = cls.getDeclaredMethod("main", String[].class);  
    String[] args = {"arg1", "arg2"};  
    main.invoke(null, args); // static methods are invoked with null as first argument
} else {
    System.err.println("Cannot run " + file);
}