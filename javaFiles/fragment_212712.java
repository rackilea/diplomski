public void test() {
    System.out.println("Hello");
    Multimap<String, String> myMultimap = ArrayListMultimap.create();
    // Adding some key/value
    myMultimap.put("Fruits", "Bannana");
    myMultimap.put("Fruits", "Apple");
    myMultimap.put("Fruits", "Pear");
    myMultimap.put("Vegetables", "Carrot");

    for (Map.Entry<String, String> e : myMultimap.entries()) {
        System.out.println("K : " + e.getKey() + " V : " + e.getValue());
    }

}