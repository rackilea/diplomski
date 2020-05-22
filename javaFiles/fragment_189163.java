ListMultimap<Integer, String> m = ArrayListMultimap.create();
m.put(4, "Bob");
m.put(5, "Mary");
m.put(5, "Sue");
...

for (String name : m.get(5)) { ... } // iterates ["Mary", "Sue"]