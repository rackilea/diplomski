class MyArrayList<T> {
    private List<T> list;

    public MyArrayList() {
        list = new ArrayList<T>();
    }

    public boolean add(T t) {
        return list.add(t);
    }
    //add other desired methods as well
}