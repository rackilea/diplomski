class MyList<T> extends ArrayList<T> {

public <V> MyList<V> map(IMapper<T, V> mapper) {
    MyList<V> list = new MyList<>();
    for (T v : this) {
        list.add(mapper.map(v));
    }
    return list;
}