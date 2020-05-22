List<String> list = new ArrayList<>();

public void set(int index, String s) {
    while(list.size() <= index) list.add(null);
    list.set(index, s);
}