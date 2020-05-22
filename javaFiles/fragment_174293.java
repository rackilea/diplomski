public class MatrixHolder {
    private List<String[][]> matrices = new ArrayList<>();

    public void addMatrix(String[][] matrix) {
        matrices.add(matrix);
    }

    public void printMatirces() {
        for(int i = 0; i < matrices.get(0).length; i++) {
            for(int j = 0; j < matrices.size(); j++) {
                System.out.print(rowString(matrices.get(j)[i]) + " ");
            }
            System.out.println();
        }
    }

    private static String rowString(String[] row) {
        StringBuilder sb = new StringBuilder();
        for(String s : row)
            sb.append(s);
        return sb.toString();
    }
}