public static void main(String[] args) throws Exception {
    Object result = null;

    // Get the class by name:
    Class<?> c = Class.forName("testjavaapp.Main$Test1");

    // Get its 2 different constructors:
    Constructor<?> conEmpty = c.getConstructor(); // Empty constructor
    Constructor<?> conString = c.getConstructor(String.class); // Constructor with string param

    // Now invoke the constructors: 
    result = conEmpty.newInstance(); // prints "Empty constructor"
    result = conString.newInstance("Hello"); // prints "String constructor: Hello"

    // The empty constructor (but not others) can also be invoked 
    // directly from the Class object.
    // --NOTE: This method has been marked for deprecation since Java 9+
    result = c.newInstance(); // prints "Empty constructor"
    result = c.newInstance("Hello"); // !! Compilation Error !!
}