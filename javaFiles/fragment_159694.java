class Statistics {

    private final static int N = 180;
    Queue<Integer> queue = new LinkedList<Integer>();
    SortedMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();

    public int insertAndGetSmallerCount(int x) {

        queue.add(x);                                // O(1)
        counts.put(x, getCount(x) + 1);              // O(log N)

        int lessCount = 0;                           // O(N), unfortunately
        for (int i : counts.headMap(x).values())     // use Guavas TreeMultiset
            lessCount += i;                          // for O(log n)

        if (queue.size() > N) {                      // O(1)
            int oldest = queue.remove();             // O(1)
            int newCount = getCount(oldest) - 1;     // O(log N)
            if (newCount == 0)
                counts.remove(oldest);               // O(log N)
            else
                counts.put(oldest, newCount);        // O(log N)
        }

        return lessCount;
    }

    private int getCount(int x) {
        return counts.containsKey(x) ? counts.get(x) : 0;
    }

}