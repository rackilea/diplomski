Map<String, MyGroup> map = new HashMap<String, MyGroup>();
Iterator<Map.Entry<String, MyGroup>> entries = map.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry<String, MyGroup> entry = entries.next();
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}