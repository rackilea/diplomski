public static void weightedSort2(Weighted[] values) {
    // Calculate the total weight.
    int total = 0;
    for (Weighted v : values) {
        total += v.getWeight();
    }
    // Start with all of them.
    List<Weighted> remaining = new ArrayList(Arrays.asList(values));
    // Take each at random - weighted by it's weight.
    int which = 0;
    do {
        // Pick a random point.
        int random = (int) (Math.random() * total);
        // Pick one from the list.
        Weighted picked = null;
        int pos = 0;
        for (Weighted v : remaining) {
            // Pick this ne?
            if (pos + v.getWeight() > random) {
                picked = v;
                break;
            }
            // Move forward by that much.
            pos += v.getWeight();
        }
        // Removed picked from the remaining.
        remaining.remove(picked);
        // Reduce total.
        total -= picked.getWeight();
        // Record picked.
        values[which++] = picked;
    } while (!remaining.isEmpty());
}