public static List<Integer> flatten(Object object) {
    List<Integer> list = new ArrayList<>();
    helper(object, list);
    return list;
}

private static void helper(Object object, List<Integer> list) {
    if (object instanceof Integer) {
        list.add((Integer) object);
    } else if (object instanceof int[]) {
        for (int a : (int[]) object)
            list.add(a);
    } else if (object instanceof Object[]) {
        for (Object obj : (Object[]) object)
            helper(obj, list);
    } else if (object instanceof Iterable) {
        for (Object obj : (Iterable) object)
            helper(obj, list);
    } else {
        throw new IllegalArgumentException();
    }
}