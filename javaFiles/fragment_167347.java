for (int i = 0; i < rows; i++) { //iterate through every row
        for (int j = 0; j < columns; j++) { //iterate through every column
            tilemap[i][j] = r.nextInt(5); //place an integer between 0 (inclusive) and 5 (exclusive) at the specified location in the 2d array
            System.out.print(" " + tilemap[i][j]); //print the integer that was just placed with a preceding space
        }

        System.out.println(" "); //print a new line since we've reached the end of the row
    }