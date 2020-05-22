public Reference<String> runMethod(final int key, Reference <String> result) {
    return ...;
}
...
Reference<String> ref = ...
ref = runMethod(0, ref);
// ref is now whatever you returned from the method