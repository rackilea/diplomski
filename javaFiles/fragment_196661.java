List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 1, 2, 3));

for (int i = 0; i < list.size() - 1; i++) {
    for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i).equals(list.get(j))) {
            list.remove(j);
            j--;
        }
    }
}

System.out.println(list); // [1, 2, 3]