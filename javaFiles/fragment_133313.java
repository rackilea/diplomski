public static void main(String[] args){

    System.out.println("Let's create a 2Dim Array!");

    int[][] anArray = Array2DMethods.readInputs();

    System.out.println("max " + Array2DMethods.max(anArray)); 

    Array2DMethods.rowSum(anArray);
    Array2DMethods.columnSum(anArray);

    System.out.println("Square " + Array2DMethods.isSquare(anArray));

    Array2DMethods.displayOutputs(anArray);

}