// Can do a weighted sort on weighted items.
public interface Weighted {
    int getWeight();
}

/**
 * Weighted sort of an array - orders them at random but the weight of each
 * item makes it more likely to be earlier.
 *
 * @param values
 */
public static void weightedSort(Weighted[] values) {
    // Build a list containing as many of each item to make up the full weight.
    List<Weighted> full = new ArrayList<>();
    for (Weighted v : values) {
        // Add a v weight times.
        for (int i = 0; i < v.getWeight(); i++) {
            full.add(v);
        }
    }
    // Shuffle it.
    Collections.shuffle(full);
    // Roll them out in the order required.
    int i = 0;
    do {
        // Get the first one in the shuffled list.
        Weighted next = full.get(0);
        // Put it back into the array.
        values[i++] = next;
        // Remove all occurrences of that one from the list.
        full.remove(next);
    } while (!full.isEmpty());
}

// A bunch of weighted items.
enum Heavies implements Weighted {

    Rare(1),
    Few(3),
    Common(6);
    final int weight;

    Heavies(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}

public void test() {
    Weighted[] w = Heavies.values();
    for (int i = 0; i < 10; i++) {
        // Sort it weighted.
        weightedSort(w);
        // What did we get.
        System.out.println(Arrays.toString(w));
    }
}