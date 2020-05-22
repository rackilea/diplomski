final int rows = 10;
final int cols = 10;

try (FileDoubleMatrix arr = new FileDoubleMatrix(
            new File("array.dat"), rows, cols)) {

    System.out.println("BEFORE:");
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            System.out.print(arr.get(row, col) + " ");
        }
        System.out.println();
    }

    // Process array; here we increment the values
    for (int row = 0; row < rows; row++)
        for (int col = 0; col < cols; col++)
            arr.set(row, col, arr.get(row, col) + (row * cols + col));

    System.out.println("\nAFTER:");
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++)
            System.out.print(arr.get(row, col) + " ");
        System.out.println();
    }
} catch (IOException e) {
    e.printStackTrace();
}