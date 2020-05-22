Map<String, Records> map = new HashMap<String, Records> ();

//Populate HashMap

for(Map.Entry<String, Record> entry: map.entrySet()) {
    System.out.println(entry.getKey() + " : " + entry.getValue());
}