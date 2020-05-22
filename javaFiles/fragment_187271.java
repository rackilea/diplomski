MyEnum enumVal;
try {
    enumVal = MyEnum(val);
} catch (IllegalArgumentException iae) {
    enumVal = null;
}