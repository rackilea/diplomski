HashMap<String,List<String>> myMap = new HashMap<String,List<String>>();

if (myMap.containsKey(mandatory_tag)) {
    List<String> values = myMap.get(mandatory_tag);
    if (values!=null) {
       values.add(id)
    } else {
        values = new List<String>();
        values.add(id);
    }
}