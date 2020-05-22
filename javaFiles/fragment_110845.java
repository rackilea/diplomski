public static void main(String... args) {
    uniqueCombinations(4, 8);
}

private static void uniqueCombinations(int depth, int maxValue) {
    int[] ints = new int[depth];
    long combinations = (long) Math.pow(maxValue, depth);
    LOOP:
    for (long l = 0; l < combinations; l++) {
        long l2 = l;
        // create a combination.
        for (int i = ints.length - 1; i >= 0; i--) {
            ints[i] = (int) (l2 % maxValue + 1);
            l2 /= maxValue;
        }
        // check the combination.
        for (int i = 0; i < ints.length; i++)
            for (int j = i + 1; j < ints.length; j++)
                if (ints[i] == ints[j]) continue LOOP;
        // print a result.
        System.out.println(Arrays.toString(ints));
    }
}