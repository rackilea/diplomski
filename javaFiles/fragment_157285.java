public boolean isDiagonallyDominant(int[][] array) {
    int otherTotal = 0;

    // Loop through every row in the array
    for(int row = 0; row < array.length; row++) {
        otherTotal = 0;

        // Loop through every element in the row
        for(int column = 0; column < array[row].length; column++) {

            // If this element is NOT on the diagonal
            if(column != row) {

                // Add it to the running total
                otherTotal += Math.abs(array[row][column]);
            }
        }

        // If this diagonal element is LESS than the sum of the other ones...
        if(Math.abs(array[row][row]) < otherTotal) {

            // then the array isn't diagonally dominant and we can return.
            return false;
        }
    }
    return true;
}