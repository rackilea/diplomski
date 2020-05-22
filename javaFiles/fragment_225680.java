final Map<Integer, Float> map = new HashMap<Integer, Float>();
List<Integer> list = new ArrayList<Integer>(); // this assignment is unncessary [1]

map.put(0, 0.0f);
map.put(1, 5.0f);
map.put(2, 2.0f);

list = new ArrayList<Integer>(map.keySet()); // 1. assignment is replaced here

Collections.sort(list, new Comparator<Integer>() {
    public int compare(Integer left, Integer right) {
        Float leftCost = map.get(left);
        Float rightCost = map.get(right);
        return leftCost.compareTo(rightCost);
    }
})