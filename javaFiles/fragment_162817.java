static enum MyEnum {}
static class EnumValue<T extends Enum<T>> {
    Class<T> enumClass;
    EnumValue(Class<T> enumClass) {
        this.enumClass = enumClass;
    }
    Class<T> enumClass() { return enumClass; }
}