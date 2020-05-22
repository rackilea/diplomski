public static void main(String... args) throws IOException {
    int[] nums = new int[10*1000 * 1000];
    {
        long start = System.nanoTime();
        product2(nums);
        long time = System.nanoTime() - start;
        System.out.printf("Took %.3f seconds to take the product of %,d ints using an int[].%n", time / 1e9, nums.length);
    }
    {
        long start = System.nanoTime();
        product(nums);
        long time = System.nanoTime() - start;
        System.out.printf("Took %.3f seconds to take the product of %,d ints using reflections.%n", time / 1e9, nums.length);
    }
}

public static double product(Object array) {
    double product = 1;
    for (int i = 0, n = Array.getLength(array); i < n; i++)
        product *= ((Number) Array.get(array, i)).doubleValue();
    return product;
}

public static double product2(int... nums) {
    double product = 1;
    for (int i = 0, n = nums.length; i < n; i++)
        product *= nums[i];
    return product;
}