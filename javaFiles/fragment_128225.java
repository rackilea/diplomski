public static void main(String[] args) {
    String str = "ID1 John\n"
            + "ID2 Jerry\n"
            + "ID3 John\n"
            + "ID4 Mary\n"
            + "ID5 John";

    //replace all the first part which contain (ID_Number_Space)
    //And split with \n
    String spl[] = str.replaceAll("(ID\\d+\\s)", "").split("\n");

    //result of this array is [John, Jerry, John, Mary, John]

    //create a map, which contain your key (name) value (nbr occurrence)
    Map<String, Integer> map = new HashMap<>();
    for (String s : spl) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }

    //Print your array
    for (Map.Entry entry : map.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
    }
}