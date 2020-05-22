for(int i = 0; i < matrix.length; i++) {
    test[] t = matrix[i]; // t is obviously a local variable.

    // This will assign a new array to the local variable t:
    t = new test[5];

    // matrix[i] is still null, to prove it:
    System.out.println(matrix[i]); // Prints "null"
}