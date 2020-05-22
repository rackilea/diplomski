public static void IterateThis() {
    ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
    array.add(new ArrayList<String>());
    array.add(new ArrayList<String>());

    array.get(0).add("1");
    array.get(0).add("2");
    array.get(0).add("2");
    array.get(1).add("4");
    array.get(1).add("5");
    array.get(1).add("6");

    Iterator<ArrayList<String>> it = array.iterator();

    int topLevelIteratorResetCounter = 0;
    int noOfIteratorNextRequired = 1;

    int size = array.size();

    while (it.hasNext()) {

        ArrayList<String> strList = it.next();
        if (noOfIteratorNextRequired > strList.size())
            break;
        Iterator<String> itString = strList.iterator();
        int numtimes = 0;
        String str = null;
        while (numtimes != noOfIteratorNextRequired) {
            str = itString.next();
            numtimes++;
        }
        System.out.println(str);
        numtimes = 0;
        topLevelIteratorResetCounter++;
        if (topLevelIteratorResetCounter == size) { //as column count is equal to column size
            it = array.iterator();  //reset the iterator
            noOfIteratorNextRequired++;
            topLevelIteratorResetCounter = 0;
        }
    }
}