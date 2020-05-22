public static void main(String[] args) throws Exception {

    Map<String, Integer> lookup = 
        new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);

    lookup.put("One", 1);
    lookup.put("tWo", 2);
    lookup.put("thrEE", 3);

    System.out.println(lookup.get("Two"));
    System.out.println(lookup.get("three"));
}