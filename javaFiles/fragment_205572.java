private static void fill(Collection c) {
    MyItem Eight = new MyItem("Eight");
    c.add(new MyItem("Five")); c.add(new MyItem("One")); c.add(Eight); c.add(new MyItem("Three"));
    c.add(new MyItem("Four")); c.add(new MyItem("One")); c.add(Eight); c.add(new MyItem("Nine"));
    c.remove(3); c.add(new MyItem("Seven"));
    System.out.println(c);//output?
}