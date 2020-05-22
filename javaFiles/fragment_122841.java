// We will assume that grid is the name of the matrix in the Table object

public void enterFromLeft(int numToEnter, int row){

    for(int i = grid[row].length - 1; i > 0; i--){

        // Now we check if that spot is a 0 - if it is,
        // we need to shift another number over to fill the space

        if(grid[row][i] == 0){

            // Shifts the rightmost number to this spot by
            // iterating from right to left over the row to find a non-0 number

            for(int j = i; j > 0; j--){

                // Checks if the number is non-0 - and if it is, sets the
                // empty space to said number and sets the number to 0 -
                // This essentially moves the rightmost non-0 tile to the right.

                if(grid[row][j] != 0){

                    grid[row][i] = grid[row][j];
                    grid[row][j] = 0;

                    j = -1; // Ends the for loop

                }

            }

            // If grid[row][i] is still 0, it means that there were no non-0
            // numbers in the regular grid, we will need to fill that space
            // with numToEnter. If we do that, there will be no other numbers
            // we need to shift right, so we can end the loop.

            if(grid[row][i] == 0){

                grid[row][i] = numToEnter;

                i = -1; // To end the loop

            }

        }

    }

}