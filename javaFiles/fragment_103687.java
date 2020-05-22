public static void main(String[] args) {
    Map<String, List<Integer>> sample = new HashMap<String, List<Integer>>();
    List first = new ArrayList();
    first.add(1);
    first.add(2);
    first.add(3);
    List second = new ArrayList();
    second.add(4);
    second.add(5);
    second.add(6);
    List third = new ArrayList();
    third.add(1);
    third.add(2);
    third.add(3);
    sample.put("first", first);
    sample.put("second", second);
    sample.put("third", third);
    removeDuplicates(sample);
    System.out.print(sample.size()); // now it will print 2

}

private static void removeDuplicates(Map<String, List<Integer>> sample) {
    Collection<List<Integer>> list = sample.values();
    for(Iterator<List<Integer>> itr = list.iterator(); itr.hasNext();) {
        if(Collections.frequency(list, itr.next())>1) {
            itr.remove();
        }
    }
}