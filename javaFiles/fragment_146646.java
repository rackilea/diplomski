public static <P> P toPrimitiveArray(List<?> list) {
    Object obj0 = list.get(0);
    Class<?> type;
    // "unbox" the Class of obj0
    if (obj0 instanceof Integer)
        type = int.class;
    else if (obj0 instanceof Double)
        type = double.class;
    else if (...)
        type = ...;
    else
        throw new IllegalArgumentException();

    Object array = Array.newInstance(type, list.size());

    for (int i = 0; i < list.size(); i++) {
        Array.set(array, i, list.get(i));
    }

    return (P) array;
}