File classFile = new File("/eraseme");
URL url = classFile.toURL();
URL[] urls = new URL[] { url };
ClassLoader cl = new URLClassLoader(urls);      
Class cls = cl.loadClass("Eraseme");  // will try to load /eraseme/Eraseme.class
TestApi test = (TestApi) cls.newInstance();
System.out.println(test.getVersion());