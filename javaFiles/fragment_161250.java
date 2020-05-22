public class StackoverflowMain {

    public static void main(String[] args) {
        String a = "3, 4, 1, 2, 3";
        String b = "19, 24, 32, 68, 50";

        // Map-approach: use a map that maps a key to a list of values
        Map<Integer, List<Integer>> ab = new TreeMap<>();
        // Pair-approach: make a sortable POJO that holds a key and a value only
        // and create a data structure that holds them sorted
        SortedSet<Pair> pairList = new TreeSet<Pair>();

        // split both Strings by comma
        String[] aSplit = a.split(",");
        String[] bSplit = b.split(",");

        // check if the length of the resulting arrays is the same
        if (aSplit.length == bSplit.length) {
            // if yes, go through the arrays of numbers
            for (int i = 0; i < aSplit.length; i++) {
                int key = Integer.parseInt(aSplit[i].trim());
                int value = Integer.parseInt(bSplit[i].trim());

                // in the Pair-approach, you just have to create a Pair with the value found
                Pair pair = new Pair(key, value);
                // and add it to the set of pairs
                pairList.add(pair);

                // the following check is only needed for the Map-solution
                if (ab.containsKey(key)) {
                    // if the key is already present,
                    // just add the new value to its value list
                    ab.get(key).add(value);
                    // sort the value list each time a new value has been added
                    ab.get(key).sort(Comparator.naturalOrder());
                } else {
                    // if the key is not present in the Map so far,
                    // create a new List for the value
                    List<Integer> valueList = new ArrayList<>();
                    // add the value to that list
                    valueList.add(value);
                    // and put both into the Map
                    ab.put(key, valueList);
                }
            }
        } else {
            System.err.println("The Strings have different amounts of elements!");
        }

        // print what's in the Map
        System.out.println("Map-approach:");
        for (int key : ab.keySet()) {
            List<Integer> value = ab.get(key);
            for (int val : value) {
                System.out.println(key + " : " + val);
            }
        }

        System.out.println("————————————————");

        System.out.println("Pairs-approach:");
        for (Pair pair : pairList) {
            System.out.println(pair.key + " : " + pair.val);
        }
    }

    /**
     * This class is needed for the Pair-approach.
     * It is comparable (and by that, sortable) and will be sorted by key
     * and if the keys are equal, it will sort by value.
     */
    static class Pair implements Comparable<Pair> {
        int key;
        int val;

        Pair(int key, int value) {
            this.key = key;
            this.val = value;
        }

        @Override
        public int compareTo(Pair otherPair) {
            if (key == otherPair.key) {
                if (val == otherPair.val) {
                    return 0;
                } else if (val < otherPair.key) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (key < otherPair.key) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}