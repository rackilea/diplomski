// Here the compiler knows that the object is a string and can bind the
// method call to the String version of the overloaded method.
whatsThis(String.class.cast(msg));

// Here the compiler knows that Class.forName will return some class object, but
// only at runtime is it known that the class will be the string class.  Thus
// the compiler binds to the Object version of the overloaded method.
whatsThis(Class.forName("java.lang.String").cast(msg));