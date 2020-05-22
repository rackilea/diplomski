public static int[] derangement(int n){
    Random rand = new Random();
    int[] result = new int[n];
    SortedMap<Double, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
        map.put(rand.nextDouble(), i);
    }
    int i = 0;
    for (Double key: map.keySet()) {
        result[i] = map.get(key);
        i++;
    }
    return result;
}