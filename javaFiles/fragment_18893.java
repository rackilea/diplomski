class Multipletypeparameters<T, K> {
    T obj1;
    K obj2;
    private final BiFunction<T, K, T> add;

    public Multipletypeparameters(BiFunction<T, K, T> add) {
        this.add = add;
    }
    public void setting(T obj1, K obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public T add(){
        return add.apply(obj1, obj2);
    }
}