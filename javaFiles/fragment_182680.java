static Scanner read = new Scanner(System.in);

public static void main(String[] args) {
    double[] array = new double[5];
    System.out.println("enter number");

    //for loop to fill array 
    for (int i = 0; i < array.length; i++) {
        array[i] = read.nextDouble();
    }

    double max1 = 0;

    //for loop to find first max value 
    for (int i = 0; i < array.length; i++) {
        if (array[i] > max1) {
            max1 = array[i];
        }
    }
    double max2 = 0;

    //for loop to find second max value 
    for (int i = 0; i < array.length; i++) {
        if (array[i] > max2 && array[i] != max1) {
            max2 = array[i];
        }
    }

    System.out.println("the product of two most maximum value is " + (max1 * max2));     // the product of two max value
    // end main
}