public static int[] findSubjectTot(int[][] x) {
    int tot[] = new int[x[0].length];

    for (int i = 0; i < x[0].length; i++) {
        for (int j = 0; j < x.length; j++) {
            tot[i] += x[j][i];
        }
    }
    return tot;
}