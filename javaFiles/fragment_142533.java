PriorityQueue<String> reversed =
    new PriorityQueue<String>(sQ.size(), new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
    }
});
reversed.addAll(sQ); // now `reversed` contains the reversed priority queue