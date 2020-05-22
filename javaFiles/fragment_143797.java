ArrayList<URL> urls = new ArrayList<URL>();
urls.add(new File("/path/to/your.class").toURI().toURL()); //can add several..

ClassLoader cl = new URLClassLoader(urls.toArray(new URL[urls.size()]));
Class<?> c;
c = Class.forName("your.class.name", false, cl); //now you have your class

Method m = c.getMethod("main", String[].class); //now your have your method
m.invoke(null, new Object[] { "argument1", "argument2" }); //now you "run that code"