public static List<String> transformer(List list) {
    List<String> al = new ArrayList<String>();
    Iterator iter = list.iterator();
    while (iter.hasNext()) {
        al.add(iter.next().toString());
    }
    return al;
}