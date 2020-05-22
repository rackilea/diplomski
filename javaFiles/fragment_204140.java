public static void main(String[] args) {
    Map<String, Class<? extends Number>> map = new HashMap<>();
    Class<? extends Number> someNumberClass = map.get("Double");
    if (Integer.class.isAssignableFrom(someNumberClass)) {
        acceptInteger((Class<Integer>) someNumberClass);
    }
}

public static void acceptInteger(Class<Integer> c) { }