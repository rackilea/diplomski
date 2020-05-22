while (eachIntEntered != 0) {   
        // if the number entered does not equal 0, add one to numberOfInt
        // if the number entered is positive, add the number to sumOfPositive

        if (eachIntEntered > 0 ) {
        numberOfInts++;
        sumOfPositive += eachIntEntered;

        } 
        // if the number entered is odd, add the number to sumOfOdd

        if (eachIntEntered % 2 != 0) {
            sumOfOdd += eachIntEntered;
        }
        if (eachIntEntered < minInt) {
            minInt = eachIntEntered;
        }
        // if the number entered is not 0, assign it to numberOfInt

        eachIntEntered = myScanner.nextInt();

    } // end of while loop