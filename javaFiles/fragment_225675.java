public static void main(String args[]) {

    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("A", 34);
    map.put("B", 25);
    map.put("C", 50);
    map.put("D", 50); // "duplicate" value

    System.out.println(entriesSortedByValues(map));
}