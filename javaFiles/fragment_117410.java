List <Class<?>> classes = new ArrayList<Class<?>>();

// alternatively, classes.add(com.foo.MyClass1.class);
classes.add(Class.forName("com.foo.MyClass1"));  
classes.add(Class.forName("com.foo.MyClass2"));
// ...etc

Method m = classes.get(0).getDeclaredMethod("staticFunction");
m.invoke(null); // pass in an instance of the class if this is an instance method