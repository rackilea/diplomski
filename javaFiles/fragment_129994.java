public static void main(String[] args) {
    List<Object> list1 = new ArrayList<Object>();
    list1.add("operator1, id1");
    list1.add("operator1, id2");
    list1.add("operator2, id3");
    list1.add("operator2, id4");
    list1.add("operator3, id5");
    list1.add("operator4, id6");

    List<Object> list2 = new ArrayList<Object>();
    list2.add("operator4, id7");
    list2.add("operator3, id8");
    list2.add("operator2, id9");
    list2.add("operator2, id10");
    list2.add("operator1, id11");
    list2.add("operator1, id12");

    Map<String, String> map = new HashMap<String, String>();
    List<Object> list3 = new ArrayList<Object>();

    Iterator<Object> it1 = list1.iterator();
    Iterator<Object> it2 = list2.iterator();

    while (it1.hasNext() && it2.hasNext()) {
        String[] line1 = ((String) it1.next()).split(",");
        map.put(line1[0], map.get(line1[0]) == null ? line1[1] : map.get(line1[0]) + ", " + line1[1]);

        String[] line2 = ((String) it2.next()).split(",");
        map.put(line2[0], map.get(line2[0]) == null ? line2[1] : map.get(line2[0]) + ", " + line2[1]);
    }

    for (Map.Entry<String, String> entry : map.entrySet()) {
        String item = entry.getKey() + "," + entry.getValue();
        System.out.println(item);
        list3.add(item);
    }
}