int maxIndex = IntStream.range(1, nums.size()).reduce(0, (i, j) -> {
    int left = nums.get(i);
    int right = nums.get(j);
    return Integer.max(left, right) == left ? i : j;
});

nums.remove(maxIndex);