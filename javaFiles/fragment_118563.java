public static List<Integer> sieve(int limit) {
    boolean[] array = new boolean[limit - 2];
    Arrays.fill(array, true);
    int end = (int)Math.sqrt(limit);

    for (int i = 2; i <= end; i++) {
        if (array[i - 2]) {
            int j = i * i;
            int k = 0;
            while (j < limit) {
                array[j - 2] = false;
                j = i * i + i * ++k;
            }
        }
    }

    List<Integer> result = new ArrayList<>();
    for (int l = 2; l < limit; l++) {
        if (array[l - 2]) {
            result.add(l);
        }
    }

    return result;
}