public int[][] fn2Array(Function<Integer, Integer> fn, int x) {
    int[][] result = new int[x][2];
    for (int i; i < x; i++) {
        result[i][0]=i+1;
        result[i][1]=fn.apply(i+1);
    }
    return result;
}