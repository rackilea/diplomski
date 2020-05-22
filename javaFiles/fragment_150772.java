public static <T extends Enum<T>> T randomMember(Class<T> enumType) {
    T[] constants = enumType.getEnumConstants();
    // Return a random element of constants array
}

...

MyEnum rand = randomMember(MyEnum.class);