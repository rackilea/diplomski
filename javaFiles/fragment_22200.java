public static void main(String[] args) {
    TreeMultimap<Integer, Integer> map = TreeMultimap.create(Ordering.natural().reverse(), Ordering.natural());
    map.put(1, 456008);
    map.put(1, 456600);
    map.put(1, 456666);
    map.put(2, 560089);
    map.put(4, 456098);
    map.put(4, 567789);
    System.out.println(map);
}