// Usually better to use List than ArrayList for declared generic types
public static TreeMap<String, List<Double>> readTable(Scanner dataSource) {
    TreeMap<String, List<Double>> map = new TreeMap<>();
    String state = null;
    while (dataSource.hasNext()) {
        String next = dataSource.next(); // Should never be null
        try {
            Double d = Double.parseDouble(next);
            // Ignores numbers received before state is set
            if (state != null)
                // If state has been set, list that must have been initialized
                map.get(state).add(d); 
        } catch (NumberFormatException e) {
            // Assumes any non-double is a state
            state = next;
            // Initialize map entry with empty list
            map.put(state, new ArrayList<>());
        }
    }
    return map;
}