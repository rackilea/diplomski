List<Integer> list = Arrays.asList(1, 1, 5, 3, 7, 7, 7, 3, 11, 2, 2, 3, 1);
System.out.println("list: " + list);
for (int i = 0, prev = -1; i < list.size(); i++) {
    if (i == list.size() - 1 || ! list.get(i).equals(list.get(i + 1))) {
        System.out.printf("number: %d, count: %d%n", list.get(i), i - prev);
        prev = i;
    }
}