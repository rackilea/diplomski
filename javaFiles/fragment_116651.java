Map<String, LinkedList<CheckPoint>> map = new HashMap<>();
map.put("A", new LinkedList<>());
map.put("B", new LinkedList<>());
map.put("C", new LinkedList<>());

for(CheckPoint c : checkPointList) {
    map.computeIfAbsent(c.getTag(), ignored -> new LinkedList<>()).add(c);
}