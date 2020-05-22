private static class Matrix extends AbstractList<List<Integer>> implements List<List<Integer>> {
    final int[][] data;

    private static class Row extends AbstractList<Integer> implements List<Integer> {
        final int[] row;

        public Row(int[] row) {
            this.row = row;
        }

        @Override
        public Integer get(int index) {
            return row[index];
        }

        @Override
        public int size() {
            return row.length;
        }
    }

    public Matrix(int[][] data) {
        this.data = data;
    }

    @Override
    public List<Integer> get(int index) {
        return new Row(data[index]);
    }

    @Override
    public int size() {
        return data.length;
    }
}

public List<List<Integer>> asMatrix(int[][] data) {
    return new Matrix(data);
}

private void test() {
    int[][] test = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };
    List<List<Integer>> matrix = asMatrix(test);
    System.out.println(matrix);
}