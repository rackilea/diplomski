public static void main(String[] args) {
        double[][] matrix = new double[][] {
            {1,2,3},
            {1,2,3},
            {1,2,3}
        };
        //Calculate
        RealMatrix A = MatrixFunctions.kernel(MatrixUtils.createRealMatrix(matrix));
        System.out.println(A); // displays C formatted appropriately
    }