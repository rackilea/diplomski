public LinkedList createSelectFrom(Class anEnum) throws Exception {
    if (!anEnum.isEnum()) {
        throw new Exception("I only accept enums...");
    }
    Object[] values = anEnum.getEnumConstants();
    for (Object value : values) {
        System.out.println(((Enum)value).name() + " __ " + ((HasCode) value).code());
    }
}