public static A<T> getType(Class<T> type) {
    if (type.equals(String.class)) {
        return new B();
    } else if (type.equals(HashMap.class)) {
        return new C();
    }
}