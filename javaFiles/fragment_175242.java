// Example Input
String[][] inputs = new String[][]{
        {"one", "two"},
        {"two", "three"},
        {"five", "six"},
        {"six", "one"}
};

// Populate
for (String[] pair : inputs) {
    String bigger = pair[0];
    String smaller = pair[1];

    if (!greaterThan.containsKey(bigger))
        greaterThan.put(bigger, new HashSet<>());
    greaterThan.get(bigger).add(smaller);

}