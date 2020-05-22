private static void fill(Map<?,?> map) {
    MyItem Eight = new MyItem("Eight");
    map.put(5, new MyItem("Five")); map.put(1, new MyItem("One")); map.put(8, Eight); map.put(3, new MyItem("Three"));
    map.put(4, new MyItem("Four")); map.put(1, new MyItem("1")); map.put(8, Eight); map.put(9, new MyItem("Nine"));
    map.remove(3); map.put(7, new MyItem("Seven"));
    System.out.println(map);//output?
}