int argListLength = 1; // This should really be the number of parsed arguments
Class[] argumentTypes = new Class[argListLength];
Object[] argumentValues = new Object[argListLength];

// In reality you will want to do the following statement in a loop
// based on the parsed types
argumentTypes[0] = Integer.TYPE;

// In reality you will want to do the following statement in a loop
// based on the parsed values
argumentValues[0] = 5;

Constructor<ArrayList> constructor = null;
try {
    consrtuctor = java.util.ArrayList.class.getConstructor(argumentTypes);
} catch(NoSuchMethodException ex) {
    System.err.println("Unable to find selected constructor..."); // Display an error
    // return or continue would be nice here
}

ArrayList x = null;
try {
    x = constructor.newInstance(argumentValues);
} catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
    System.err.println("Unable to call selected constructor..."); // Display an error
    // return or continue would be nice here
}