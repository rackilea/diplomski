static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int val1 : nums1) {
        for (int val2 : nums2) {
            int sum = val1 + val2;
            map.put(sum, Arrays.asList(val1, val2));
            minHeap.offer(sum);
        }
    }

    for (int i = 0; i < k; i++) {
        int key = minHeap.poll();
        ans.add(map.get(key)); 
    }
    return ans;  //  [[1, 2], [1, 4], [1, 6]]
}