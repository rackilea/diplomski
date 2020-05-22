public static void combine(int values, int maximum, Consumer<int[]> consumer) {
    combine0(0, values, 1, maximum-values+1, new int[values], consumer);
}

static void consumer0(int index, int values, int min, int max, List<Integer> ints, Consumer<List<integer>> consumer) {
    if (index == values) {
        consumer.apply(ints);
        return;
    }
    for(int i = min; i <= max ; i ++) {
        ints[index] = i;
        comsumer0(index+1, values, min+1, max+1, ints, consumer);
    }
}