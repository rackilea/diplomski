public static MyEnum permissiveValueOf(String name) {
    for (MyEnum e : values()) {
        if (e.name().equals(name)) {
            return e;
        }
    }
    return null;
}