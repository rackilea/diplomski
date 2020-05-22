List<String> list = map.get(key);  // try to get the list
if (list == null) {                // list doesn't exist?
    list = new ArrayList<>();      // create an empty list
    map.put(key, list);            // insert it into the map
}
list.add(value);                   // update the list