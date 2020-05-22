if (readMethodName == null) {
    Class type = getPropertyType0();
    if (type == boolean.class || type == null) {
        readMethodName = "is" + getBaseName();
    } else {
        readMethodName = "get" + getBaseName();
    }
    }