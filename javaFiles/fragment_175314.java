interface Adder<T, L extends List<T>> {
    void add(L list, T t);
}

class ArrayListAdder implements Adder<String, ArrayList<String>> {
    @Override
    public void add(ArrayList<String> list, String t) {
        list.add(t);
    }
}