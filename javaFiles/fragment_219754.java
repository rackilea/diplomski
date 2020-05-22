public static <T> List<T> nInstances(int n, Supplier<T> supplier){
    List<T> list = Lists.newArrayListWithCapacity(n);
    for(int i = 0; i < n; i++){
        list.add(supplier.get());
    }
    return list;
}