Hashtable<String, String> map = new Hashtable<String, String>();
map.put("one", "een");
map.put("two", "twee");
map.put("three", "drie");

for (Iterator<Map.Entry<String, String>> i = map.entrySet().iterator(); i.hasNext(); ) {
    Map.Entry<String, String> entry = i.next();

    if ("two".equals(entry.getKey())) {
        // Removes entry from Hashtable; note, this is not the Hashtable.remove() method
        // but the Iterator.remove() method
        i.remove();
    }
}

System.out.println(map);