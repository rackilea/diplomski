public int runMethod(final int key, Reference <String> result) {
    result = null; // Only changed the method's version of the variable, and not the variable that was passed to the method
}
...
Reference<String> ref = ...
runMethod(0, ref);
// ref is still what you originally assigned it to