// Define a constant in your class. Use a HashSet for performance
private static final Set<Integer> values = new HashSet<Integer>(Arrays.asList(12, 16, 19));

// In your method:
if (values.contains(x)) {
    ...
}