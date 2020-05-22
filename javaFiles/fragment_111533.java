String path = "/path/to/your/classfiles/root/"; //not including the package structure
    ClassLoader loader = new URLClassLoader(new URL[]{new URL("file://" + path)}, Up.class.getClassLoader());

    Class clazz = loader.loadClass("foo.Hohoho"); //assuming a package "foo" for that class
    Object loadable = clazz.newInstance();
    Field field = loadable.getClass().getField("someField");  //or whatever - (this assumes you have someField on foo.Hohoho)

    System.out.println(field.get(loadable));