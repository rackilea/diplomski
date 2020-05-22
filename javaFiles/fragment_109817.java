numberOfRows = data.length;
    if (numberOfRows > 0) {
        numberOfCols = data[0].length;
    } else {
        numberOfCols = 0;
    }

    System.out.println("numberOfRows : "+numberOfRows);
    System.out.println("numberOfCols : "+numberOfCols);

    for (int row = 0, count = 0; row < numberOfRows; row++) {
        for (int col = 0; col < numberOfCols; col++) {
            arrayCount[count] = data[row][col];
            count++;
        }
    }