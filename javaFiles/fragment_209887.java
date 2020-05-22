int overlappingRowInImage1 = 0;
    int overlappingRowInImage2 = 0;
    int[][] imageArray1 = null;
    int[][] imageArray2 = null;
    // loop through the rows in the first image
    for (int row1 = 0; row1 < imageArray1.length; row1++) {
        boolean foundIdenticalRow = false;
        // loop through the rows in the second image
        for (int row2 = 0; row2 < imageArray2.length; row2++) {
            foundIdenticalRow = true;
            // two rows are identical if each column in both rows are the same
            for (int col = 0; col < imageArray1[row1].length; col++) {
                if (imageArray1[row1][col] != (imageArray2[row2][col])) {
                    foundIdenticalRow = false;
                    break;
                }
            }
            if (foundIdenticalRow) {
                overlappingRowInImage1 = row1;
                overlappingRowInImage2 = row2;
                break;
            }
        }
        if (foundIdenticalRow) {
            System.out.println("Row " + overlappingRowInImage1 + " in image 1 is overlapping with Row " +
                    overlappingRowInImage2 + " in image 2");
            break;
        }
    }