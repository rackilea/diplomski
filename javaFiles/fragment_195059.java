public class Main {

    public static void main(String[] args) {
        double[][] myArray = sortMyArray();
        printArray(myArray);
    }

    public static double[][] sortMyArray() {
        double[][] myArray = new double[][] {
            {1, 11, 21, 37, 41, 51, 61},
            {0, 10, 20, 30, 40, 50, 60},
            {2, 12, 22, 32, 42, 52, 62},
            {1, 11, 21, 31, 41, 51, 61},
        };
        Arrays.sort(myArray, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                int result = Double.compare(a[2], b[2]); 
                if (result == 0) {
                    return Double.compare(a[3], b[3]);
                } else {
                    return result;
                }
            }
        });

        return myArray;
    }

    private static void printArray(double[][] myArray) {
        for(int row = 0; row < myArray.length; row++){
            for( int column = 0; column < myArray[0].length; column++){
                System.out.print(myArray[row][column] + " ");
            }
            System.out.println();
        }
    }
}