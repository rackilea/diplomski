private static String asString(Object obj) {
    if (obj == null)
        return "null";

    Class<?> clazz = obj.getClass();
    if (clazz.isArray()) {
        try {
            Object first = Array.get(obj, 0);
            return String.valueOf(first);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "empty array";
        }
    } else {
        return String.valueOf(obj); // primitive or non-array object
    }
}

public static void main(String[] args) {
    Integer integer = Integer.valueOf(4);
    String[] stringArray = new String[] { "a", "b" };
    String nothing = null;
    int primitive = 4;
    char[] primitiveArray = { 'a', 'b' };
    int[] emptyArray = new int[0];

    System.err.println(asString(integer));        // 4
    System.err.println(asString(stringArray));    // a
    System.err.println(asString(nothing));        // null
    System.err.println(asString(primitive));      // 4
    System.err.println(asString(primitiveArray)); // a
    System.err.println(asString(emptyArray));     // empty array
}