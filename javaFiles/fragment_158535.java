java.lang.Class<?> someClass = ...;  // obtain a Class somehow

// Returns all constructors/methods/fields declared in class, 
// whether public/protected/package/private, 
// but does NOT include definitions from any ancestors:

java.lang.reflect.Constructor<?>[] declaredConstructors = someClass.getDeclaredConstructors();
java.lang.reflect.Method[] declaredMethods = someClass.getDeclaredMethods();
java.lang.reflect.Field[] declaredFields   = someClass.getDeclaredFields();

// Returns all constructors/methods/fields declared as public members 
// in the class AND all ancestors: 

java.lang.reflect.Constructor<?>[] publicInheritedConstructors = someClass.getConstructors();
java.lang.reflect.Method[] publicInheritedMethods = someClass.getMethods();
java.lang.reflect.Field[] publicInheritedFields   = someClass.getFields();