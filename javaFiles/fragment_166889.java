int size = 500000;
List<Integer> list = new ArrayList<Integer>();
for (int i = 0; i < size; i++) {
    list.add(i);
}
Collections.shuffle(list);
for (int i = 0; i < size; i++) {
    System.out.println(list.get(i));
}