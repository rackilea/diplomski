int[] arr = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2, 10};
Map<Integer, Integer> counting = new HashMap<>();
for (Integer current : arr) {
    int count = counting.compute(current, (x, n) -> n == null ? 1 : n + 1);
    if (count < 3) {
        System.out.print(current + ", ");
    }
}