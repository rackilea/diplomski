<T> void method(T... items) {
    List<T> list = new ArrayList<T>();
    for (T item : items)
        list.add(item);
    System.out.println(list);
}