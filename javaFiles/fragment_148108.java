void checkDeserialize() throws InvalidClassException {
    if (deserializeEx != null) {
        InvalidClassException ice =
            new InvalidClassException(deserializeEx.classname,
                                      deserializeEx.getMessage());
        ice.initCause(deserializeEx);
        throw ice;
    }
}