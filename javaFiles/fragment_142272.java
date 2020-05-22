Map<String, ArrayList<Integer>> map = new HashMap<>();
for (int i = 0; i < foxesList.size(); i++) {
    String fox = foxesList.get(i);
    ArrayList<Integer> list = map.get(fox);
    if (list == null) {
        list = new ArrayList<>();
        list.add(i);
        map.put(fox, list);
    } else {
        list.add(i);
    }
}