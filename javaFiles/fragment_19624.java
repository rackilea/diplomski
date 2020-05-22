public static void main(String[] args) {
    Map<Integer, String> a = new HashMap<>();
    a.put(1, "big");
    a.put(2, "hello");
    a.put(3, "world");

    Map<Integer, String> b = new HashMap<>();
    b.put(1,"hello");
    b.put(2, "world");

    a.values().removeAll(b.values()); // removes all the entries of a that are in b

    System.out.println(a); // prints "{1=big}"
}