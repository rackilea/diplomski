public void add(String s) {
    // null check here 
    List<String> list = get(s.length);
    if (list == null) {
        list = new ArrayList<>();
        put (s.lenght, list);
    }
    list.add(s);
}