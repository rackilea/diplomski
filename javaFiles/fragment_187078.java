public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {


        // Read input file
        Scanner input = new Scanner(new File("lab2-input.txt"));

        while (input.hasNextInt()) {

            // This should be here to get size of array before getting each array
            int size = input.nextInt();
            int[][] a = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    try{
                        a[i][j] = input.nextInt();

                    }
                    catch (java.util.NoSuchElementException e) {
                        // e.printStackTrace();
                    }
                }
            }

            //print the input matrix
            System.out.println("The input sorted matrix is : ");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.printf("%5d ", a[i][j]);
                }
                System.out.println();

            }

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}