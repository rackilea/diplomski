@SafeVarargs
public static <E> Object[] unpack(E... objects) {
    List<Object> list = new ArrayList<Object>();
    for (Object object : objects) {
        if (object instanceof Object[]) {
            list.addAll(Arrays.asList((Object[]) object));
        }
        else{
            list.add(object);
        }
    }

    return list.toArray(new Object[list.size()]);
}