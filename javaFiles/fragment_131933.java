public static int getHighestTuppleSum(int[] arr, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue(arr.length);
    for (int i : arr) {
        if (pq.size() < n) {
            pq.add(i);
        }
        if (pq.peek() < i) {
            pq.poll();
            pq.add(i);
        }
    }
    return pq.stream().mapToInt(Integer::intValue).sum(); 
}