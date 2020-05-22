// absolute from the classpath
MyClass.class.getResource("/myfolder/abc.txt");
// relative to the class location
MyClass.class.getResource("abc.txt");
// another relative to the class location
MyClass.class.getResource("myfolder/abc.txt");