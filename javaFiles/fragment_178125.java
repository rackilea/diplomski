private void radixSortStep(int[]nr) {
    List<Integer> value[] = new List[M];
    for (int i = 0; i < value.length; i++)
        value[i] = new ArrayList<Integer>(0);

    for (int i: indexes)
        value[nr[i]].add(i);

    int ptr = 0;
    for (int i = 0; i < M; i++)
        for (int val: value[i])
            indexes[ptr++] = val;
}