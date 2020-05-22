public static void main( String[] args ){
    List<String> str = Collections.singletonList("asd");
    String[] array = test(str);
}

static <E> E[] test(List<E> list) {
    E[] snapshot = (E[]) list.toArray(); // Unchecked cast
    return snapshot;
}