HashMap<Integer, List<JSONObject>> monthArray = new HashMap<Integer, List>();
...
if (...) {
    ...
    List l = monthArray.get(theDate);
    if (l == null) {
        l = new LinkedList<JSONObject>();
    }

    l.add(event);

    monthArray.put(theDate, l);
}