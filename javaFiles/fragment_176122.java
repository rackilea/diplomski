private static final List LEAVES = Arrays.asList(
        Boolean.class, Character.class, Byte.class, Short.class,
        Integer.class, Long.class, Float.class, Double.class, Void.class,
        String.class);

public static String toStringRecursive(Object o) throws Exception {

    if (o == null)
        return "null";

    if (LEAVES.contains(o.getClass()))
        return o.toString();

    StringBuilder sb = new StringBuilder();
    sb.append(o.getClass().getSimpleName()).append(": [");
    for (Field f : o.getClass().getDeclaredFields()) {
        if (Modifier.isStatic(f.getModifiers()))
            continue;
        f.setAccessible(true);
        sb.append(f.getName()).append(": ");
        sb.append(toStringRecursive(f.get(o))).append(" ");
    }
    sb.append("]");
    return sb.toString();
}