static double avgFor(List<Integer> list) {
    int max = list.get(0);

    for (int i : list) {
        max = max < i ? max : i;
    }

    return max;
}