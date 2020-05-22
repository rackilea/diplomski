public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    System.out.println("The arraylist contains the following elements: " + list);

    System.out.printLn("List 1: " + method(list, "a"));
    System.out.printLn("List 2: " + method(list, "b"));
}

private List<String> method(List<String> list, String filter) {
    List<String> filteredList = new ArrayList<>();
    for (String s : list) {
        if (s.startsWith(filter)) {
            filteredList.add(s);
        }
    }

    return filteredList;
}