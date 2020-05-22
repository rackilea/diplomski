HashMap<Integer, String> original = new HashMap<>();
HashMap<String, ArrayList<Integer>> inverted = new HashMap<>();

original.put(1, "A");
original.put(2, "B");
original.put(3, "C");
original.put(4, "A");

for (Integer key: original.keySet()) {
    String newKey = original.get(key);

    inverted.computeIfAbsent(newKey, k -> new ArrayList<>());
    inverted.get(newKey).add(key);

}
System.out.println(original);
System.out.println(inverted);