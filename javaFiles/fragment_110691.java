public class Main {
    int[][] previousMatrix = new int[2][2];
    List<int[2][2]> matrixList = new ArrayList<>();

    public static void main(String[] args) {
        for(int i = 0; i < 4; i++){
            int[][] matrix = matrixCalc(previousMatrix);
            matrixList.add(matrix);
            previousMatrix = copy2dArray(matrix);
        }       

        for(int i = 0; i < 4; i++) {
            System.out.println(Arrays.deepToString(matrixList.get(i)));
        }
    }

    public int[][] matrixCalc(int[][] m){
        //do various calculations with m
        ...

        return m;
    }

    private int[][] copy2dArray(int[][] original){
        int[][] copy = new int[original.length][];
        for(int i = 0; i < original.length; i++){
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}