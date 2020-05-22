private static final Set<String> PRIMITIVES = 
    new HashSet<>(
        Arrays.asList("byte", "char", "short", "int", "long", "float", "double", "boolean"));

public static boolean isType(String s) {
    if (PRIMITIVES.contains(s)) {
        return true;
    }

    try {
        Class.forName(s);
    } catch (ClassNotFoundException ignore) {
        retrun false;
    }
    return true;
}