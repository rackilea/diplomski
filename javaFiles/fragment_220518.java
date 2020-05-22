Map<String, String> reversedMap = new TreeMap<String, String>(codes);

//then you just access the reversedMap however you like...
for (Map.Entry entry : reversedMap.entrySet()) {
    System.out.println(entry.getKey() + ", " + entry.getValue());
}