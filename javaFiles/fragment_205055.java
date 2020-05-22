int[] inp = {1, 2, 3, 1, 2, 1, 3};
Map<Integer, Integer> h = new HashMap<>();
List<Integer> result = new ArrayList<>();

for (int i = inp.length - 1; i >= 0; --i) {
    int cur = inp[i];
    int next = -1;
    if (h.containsKey(cur)) {
        next = h.get(cur);
    }   
    h.put(cur, i);
    result.add(next);
}

for (int i = 0; i < inp.length; ++i) {
    System.out.println("Number " + inp[i] + " next occurence at index " + result.get(inp.length - i - 1));
}