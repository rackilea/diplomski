for (int i = 0; i < NAMES.length - 1; i++) {
    String name = NAMES[i];
    PAIRS.put(name, helper(name));
}
String name = NAMES[NAMES.length - 1];
if (PAIRS.containsValue(name)) {
    PAIRS.put(name, helper(name));
} else {
    String otherKey = NAMES[ThreadLocalRandom.current().nextInt(0, NAMES.length - 1)];
    PAIRS.put(name, PAIRS.get(otherKey));
    PAIRS.put(otherKey, name);
}