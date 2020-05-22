public synchronized Method getReadMethod() {
Method readMethod = getReadMethod0();
if (readMethod == null) {
    Class cls = getClass0();
    if (cls == null || (readMethodName == null && readMethodRef == null)) {
        // The read method was explicitly set to null.
        return null;
    }
    if (readMethodName == null) {
        Class type = getPropertyType0();
        if (type == boolean.class || type == null) {
            readMethodName = "is" + getBaseName();
        } else {
            readMethodName = "get" + getBaseName();
        }
    }

    // Since there can be multiple write methods but only one getter
    // method, find the getter method first so that you know what the
    // property type is.  For booleans, there can be "is" and "get"
    // methods.  If an "is" method exists, this is the official
    // reader method so look for this one first.
    readMethod = Introspector.findMethod(cls, readMethodName, 0);
    if (readMethod == null) {
        readMethodName = "get" + getBaseName();
        readMethod = Introspector.findMethod(cls, readMethodName, 0);
    }
    try {
        setReadMethod(readMethod);
    } catch (IntrospectionException ex) {
    // fall
    }
}
return readMethod;
}