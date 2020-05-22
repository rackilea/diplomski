Map <String,Integer> m = new HashMap<String,Integer>();

m.put("A", 1);
m.put("B", 2);
m.put("C", 3);

// Iterate over keys
for (String key : m.keySet()) {
    System.out.println("Key=["+key+"], value=["+m.get(key)+"]");
}

// Iterate over values
for (Integer value : m.values()) {
    System.out.println("Value=["+value+"]");
}

// Iterate over entrySet
for (Map.Entry<String,Integer> entry : m.entrySet()) {
    System.out.println("Key=["+entry.getKey()+"], value=["+entry.getValue()+"]");
}