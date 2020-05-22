public static void main(String[] args) {
    String data[][] = {{"Nokia", "7"}, {"Blackberry", "1"}, {"Nimbus", "10"},
        {"Nokia", "7"}, {"Blackberry", "1"}, {"Nimbus", "10"}, {"Nokia", "7"},
        {"Blackberry", "1"}, {"Nimbus", "10"}, {"Zebra", "78"}};

    HashMap<String, Integer> totals = new HashMap<String, Integer>();
    for (String[] datum : data)
        totals.put(datum[0], new Integer(datum[1]) + (totals.containsKey(datum[0]) ? totals.get(datum[0]) : 0));
    System.out.println("There are " + totals.size() + " brands: " + totals);
}