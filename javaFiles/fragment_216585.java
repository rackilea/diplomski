public void testStacko() {
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {1, "foo"});
    list.add(new Object[] {6, "|bar"});
    list.add(new Object[] {15, "|baz"});
    Object[] array = list.stream()
                         .reduce(
                                  (obj1, obj2) -> 
                                   new Object[] {(int) obj1[0] * (int) obj2[0], 
                                                 (String) obj1[1] + (String) obj2[1]
                                                }
                                )
                         .get();
    System.out.println(array[0]); // 90
    System.out.println(array[1]); // foo|bar|baz
}