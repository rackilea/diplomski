public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the length of the vectors whose dot product you wish to calculate :");
    int length = Integer.parseInt(scan.nextLine());

    System.out.println("Getting values for the first vector");
    double[] arr1 = getArray(length, scan);

    System.out.println("Getting values for the second vector");
    double[] arr2 = getArray(length, scan);

    System.out.println("Calculating the dot product");
    double dotProduct = getDotProduct(arr1, arr2);

    // TODO do something with the dot product

    scan.close();
}

private static double[] getArray(int length, Scanner scan) {

    double[] vector = new double[length];
    for (int i = 0; i < length; i++) {
        System.out.println("Please enter a vector value :");
        double valuesOne = Double.parseDouble(scan.nextLine());
        vector[i] = valuesOne;
    }
    System.out.println("Your vector values are: " + Arrays.toString(vector));

    return vector;
}

private static double getDotProduct(double vOne[], double vTwo[]) {
    double product = 0.0;
    for (int i = 0; i < vOne.length; i++) {
        product = product + vOne[i] * vTwo[i];
    }
    System.out.println("Dot Product: ");
    System.out.println(product);
    return product;
}