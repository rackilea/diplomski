// Getting the jar URL which contains target class
URL[] classLoaderUrls = new URL[]{new URL("file:///home/ashraf/Desktop/simple-bean-1.0.jar")};
URLClassLoader child = new URLClassLoader (classLoaderUrls, this.getClass().getClassLoader());
Class classToLoad = Class.forName ("com.MyClass", true, child);
Method method = classToLoad.getDeclaredMethod ("myMethod");
Object instance = classToLoad.newInstance ();
Object result = method.invoke (instance);