int count = 0;

        // Process each row...
        for (int row = 0; row < matrix.length; row++) {

            count = 0;

            // Process each column...
            for (int col = 0; col < matrix[row].length; col++) {

                 // Check the cell.
                 if (matrix[row][col] != 0) {
                     count++;
                 }                     
            }
            // Row processing complete. Check count.
            if (count != 1) {
                System.out.println(count);
                return gpm;
            }
        }