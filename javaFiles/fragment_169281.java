interface StringValue {
    String getValue();
}

enum MyEnum1 implements StringValue {
    ...
    private String stringValue;
    ...

    @Override
    public String getValue() {
        return stringValue;
    }
}

static <E extends Enum<E> & StringValue>
String getPlacement(Class<E> enumClass, String inValue) {
    for(E constant : enumClass.getEnumConstants()) {
        if(inValue.contains(constant.toString()))
            return constant.getValue();
    }
    return Enum.valueOf(enumClass, "STRINGLESS").getValue();
}