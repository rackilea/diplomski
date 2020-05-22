for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols && element < primesArray.length; c++, element++) {
            System.out.print(primesArray[element]);
        }
        System.out.println();
    }