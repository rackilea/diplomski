private final static ReferenceTargetType TYPES = ReferenceTargetType.values();

public ReferenceTargetType byteToType(byte b) {
    int index = b - 1;
    if (0<=index && index<TYPES.length) return TYPES[index];
    ... throw SomeException or return null;
}