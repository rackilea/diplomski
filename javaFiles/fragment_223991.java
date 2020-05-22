Scanner matrix = new Scanner(new File("graph_input.txt"));

// Base on this you have 8 line in the matrix
String[][] arr = new String[8][];

// Read all 8 lines
for (int i = 0; i < arr.length; i++) {
    // Get the elements of line i
    arr[i] = matrix.nextLine().split("\\s+");;
}