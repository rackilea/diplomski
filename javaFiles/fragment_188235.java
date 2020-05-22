public static void main(String[] args) {
    List<String> list = Arrays.asList("Hot", "Cold", "Pressure", "Pain");

    //Solution 1
    for (String s : list) {
        if (s.length() == 4) {
            System.out.println(s); //prints Cold and Pain
        }
    }

    //Solution 2
    Map<Integer, List<String>> map = new HashMap<Integer, List<String>> ();
    for (String s : list) {
        int length = s.length();
        if (map.containsKey(length)) {
            map.get(length).add(s);
        } else {
            map.put(length, new ArrayList<String>(Arrays.asList(s)));
        }
    }

    System.out.println(map.get(4)); //prints [Cold, Pain]
    System.out.println(map.get(3)); //prints [Hot]
}