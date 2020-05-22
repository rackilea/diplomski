public static int[] nearestK(int[] a, int val, int k) {
    // omitted your checks for brevity
    final int value = val; // needs to be final for the comparator, you can also make the parameter final and skip this line
    Integer[] copy = new Integer[a.length]; // copy the array using autoboxing
    for (int i = 0; i < a.length; i++) {
        copy[i] = a[i];
    }
    Arrays.sort(copy, new Comparator<Integer>() { // sort it with a custom comparator
        @Override
        public int compare(Integer o1, Integer o2) {
            int distance1 = Math.abs(value - o1); 
            int distance2 = Math.abs(value - o2); 
            return Integer.compare(distance1, distance2);
        }
    });
    int[] answer = new int[k]; // pick the first k elements
    for (int i = 0; i < answer.length; i++) {
        answer[i] = copy[i];
    }
    return answer;
}