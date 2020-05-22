public static void main(String[] args) {

    TreeMap<Date, String> map = new TreeMap<>();

    map.put(new Date(0), "First");
    map.put(new Date(10), "Second");
    map.put(new Date(20), "Third");
    map.put(new Date(30), "Fourth");
    map.put(new Date(40), "Fifth");

    System.out.println(getClosestPrevious(map, new Date(5)));
    System.out.println(getClosestPrevious(map, new Date(10)));
    System.out.println(getClosestPrevious(map, new Date(55)));
}

private static String getClosestPrevious(TreeMap<Date, String> map, Date date) {
    return map.get(map.headMap(date, true).lastKey());
}