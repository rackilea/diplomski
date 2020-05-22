public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<String>(
                Arrays.asList("a", "b", "c", "d"));
        NavigableSet<String> set2 = new TreeSet<String>();
        set2.addAll(set.tailSet("c", false));
        set2.addAll(set.headSet("b", true));
        System.out.println(set2);
  }