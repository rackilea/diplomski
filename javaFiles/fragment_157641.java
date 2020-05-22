//get class reflections object method 1
Class aClassHandle = Class.forName("MyClass");

//get class reflections object method 2(preferred)
Class aClassHandle = MyClass.class;

//get a class reflections object method 3: from an instance of the class
MyClass aClassInstance = new MyClass(...);
Class aClassHandle = aClassInstance.getClass();



//get public class variables from classHandle
Field[] fields = aClassHandle.getFields();

//get all variables of a class whether they are public or not. (may throw security exception)
Field[] fields = aClassHandle.getDeclaredFields();

//get public class methods from classHandle
Method[] methods = aClassHandle.getMethods();

//get all methods of a class whether they are public or not. (may throw security exception)
Method[] methods = aClassHandle.getDeclaredMethods();

//get public class constructors from classHandle
Constructor[] constructors = aClassHandle.getConstructors();

//get all constructors of a class whether they are public or not. (may throw security exception)
Constructor[] constructors = aClassHandle.getDeclaredConstructors();