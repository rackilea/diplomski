private static HashMap<String, HashSet<String>> hMap = new HashMap<String, HashSet<String>>();

public static String getKey(Map<String, HashSet<String>> map, String value) {
    List<String> returnKey = new ArrayList<String>();

    for (String s : map.keySet()) {
        if (map.get(s).contains(value)) {
            returnKey.add(s);
        }
    }

    return returnKey.toString();

}

public static void main(String[] args) {
    // put sth to hMap
    System.out.println(getKey(hMap, "today"));
}