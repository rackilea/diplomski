public int runMethod(final int key, Reference <String> result) {
    result.someField = ...; // Here we are changing the object, which is the same object as what was passed to the method.
}
...
Reference<String> ref = ...
runMethod(0, ref);
// ref.someField has now been changed