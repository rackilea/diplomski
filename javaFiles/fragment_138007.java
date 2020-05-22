// your map is map = HashMap<String, String>
public void printIfContainsValue(Map mp, String value) {
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        // print if found
        if (value.equals(pair.getValue())) {
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        it.remove(); // avoids a ConcurrentModificationException
    }
}