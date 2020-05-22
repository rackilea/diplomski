Object val = field.get(obj);
Object[] objs =
    IntStream.range(0, Array.getLength(val))
        .mapToObj(i -> Array.get(val, i))
        .toArray();
String printValue = Arrays.toString(objs);