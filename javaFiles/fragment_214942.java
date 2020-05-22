// Initialize my multimap
Multimap<String, String> multimap = ArrayListMultimap.create();
multimap.put("20014", "13123");
multimap.put("20013", "45451");
multimap.put("20013", "13123");

// Set in which we store the values to know if they exist already
Set<String> allValues = new HashSet<>();
// Convert the multimap into a Map
Map<String, Collection<String>> map = multimap.asMap();
// Iterate over the existing entries
for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
    String key = entry.getKey();
    Collection<String> values =  entry.getValue();
    // Iterate over the existing values for a given key
    for (String value : values) {
        // Check if the value has already been defined if so print a log message
        if (!allValues.add(value)) {
            System.out.println(String.format("Key-%s,Value-%s", key, value));
        }
    }
}