public boolean searchTable(int[][] data, int element) {
    return searchTable(data, element, 0);
}

private boolean searchTable(int[][] data, int element, int p) {
    if (p < 0 || p > data.length) {
        return false;
    }
    int[] row = getRow(data, p);
    if (searchRow(row, element, 0)) {
        return true;
    }
    return searchTable(data, element, 1 + p);
}

private boolean searchRow(int[] data, int element, int p) {
    if (data == null || p >= data.length) {
        return false;
    }
    if (data[p] == element) {
        return true;
    }
    return searchRow(data, element, 1 + p);
}

public int[] getRow(int[][] in, int x) {
    if (in == null || x >= in.length) {
        return null;
    }
    return in[x];
}

public static void main(String[] args) {
    // I named the class Question.
    Question question = new Question();
    int[][] table = new int[][] { { 5, 2, 8, 5, 61 }, { 3, 9, 6 },
            { 10, 42, 53, 45 } };
    System.out.println(question.searchTable(table, 45));
    System.out.println(question.searchTable(table, 100));
}