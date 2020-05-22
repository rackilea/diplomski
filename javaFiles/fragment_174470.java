static public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    if (nums.length == 0)
        return res;
    Map<Integer, Integer> hash = new HashMap<>();
    for (int i : nums) {
        hash.put(i, hash.getOrDefault(i, 0) + 1);
    }

    System.out.println(hash);


    Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<> (
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
    );
    for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
        pq.offer(entry);
    }


    for (int i = 0; i < k; i++) {
        res.add(pq.poll().getKey());
    }
    return res;
}