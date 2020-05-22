boolean splittable(int[] numbers, int target) {
    boolean[] reached = new boolean[target + 1];
    reached[0] = true;

    for (int number : numbers) {
        for (int sum = target - 1; sum >= 0; --sum) {
            if (reached[sum] && sum + number <= target) {
                reached[sum + number] = true;
            }
        }
    }

    return reached[target];
}