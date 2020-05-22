private void prepareListData(List<String> listDataHeader, Map<String,
  List<String>> listDataChild) {


    // Adding child data
    listDataHeader.add("Product1");
    listDataHeader.add("product2");
    listDataHeader.add("Product3");

    // Adding child data
    List<String> top = new ArrayList<String>();
    top.add("x1");
    top.add("x2");
    top.add("x3");
    top.add("x4");
    top.add("x5");


    List<String> mid = new ArrayList<String>();
    mid.add("y1");
    mid.add("y2");
    mid.add("y3");

    List<String> bottom = new ArrayList<String>();
    bottom.add("z1");
    bottom.add("z2");
    bottom.add("z3");



    listDataChild.put(listDataHeader.get(0), top); // Header, Child data
    listDataChild.put(listDataHeader.get(1), mid);
    listDataChild.put(listDataHeader.get(2), bottom);
}