/**
 * Use a min heap to save the max k values. Time complexity: O(nlogk)
 */
public static int[] farthestKWithHeap(Integer[] a, final int val, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(4,
            new java.util.Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Math.abs(o1 - val) - Math.abs(o2 - val);
                }
            });
    for (int i : a) {
        minHeap.add(i);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    int[] c = new int[k];
    for (int i = 0; i < k; i++) {
        c[i] = minHeap.poll();
    }
    return c;
}