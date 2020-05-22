public static void main(String args[]) {
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(6);
    list.add(3);
    list.add(4);
    list.add(2);
    Collections.sort(list);
    for (Integer i : list) {
        System.out.println(i);
    }
}