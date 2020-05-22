public static int[] getRandomPeople(int[] arr, int total) {
    int[] res = new int[Math.min(arr.length, total)];
    Set<Integer> used = new HashSet<>();
    Random random = new Random();

    for (int i = 0; i < res.length; i++) {
        int j = random.nextInt(arr.length);

        while (used.contains(j)) {
            j = (j + 1) % arr.length;
        }

        res[i] = arr[j];
        used.add(j);
    }

    return res;
}