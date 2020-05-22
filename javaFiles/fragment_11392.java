// Constructing a URL form the path to JAR
URL u = new URL("file:/C:/Users/SomeUser/Projects/MyTool/plugins/myNodes/myOwn-nodes-1.6.jar");

// Creating an instance of URLClassloader using the above URL and parent classloader 
ClassLoader loader = URLClassLoader.newInstance(new URL[]{u}, MyClass.class.getClassLoader());

// Returns the class object
Class<?> yourMainClass = Class.forName("MainClassOfJar", true, loader);