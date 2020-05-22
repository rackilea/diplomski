// your map is map = HashMap<String, String>
public Map.Entry containsValue(Map mp, String value) {
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        // return if found
        if (value.equals(pair.getValue())) {
            return pair;
        }
        it.remove(); // avoids a ConcurrentModificationException
    }
    return null;
}