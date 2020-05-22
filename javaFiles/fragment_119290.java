int[] array = { 9, 0, 2, -5, 7 };
List<int[]> pairs = new ArrayList<int[]>();
for (int i = 0; i < array.length - 1; ++i) {
    if (array[i] <= 0) continue;
    for (int j = i + 1; j < array.length; ++j) {
        if (array[j] <= 0) continue;
        int sqrt = (int)Math.sqrt(array[i] + array[j]);
        if (array[i] + array[j] == sqrt * sqrt)
            pairs.add(new int[] { array[i], array[j] });
    }
}