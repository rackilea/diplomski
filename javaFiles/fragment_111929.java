SORT array //nlogn
INT counter = n*(n-1)*(n-2)/6;
FOR i = n - 1; i >= 2; i-- DO //largest length in a triangle - there must be two lower
    currentLargestNumber = array[i];
    FOR j = i - 1; j >= 1; j-- DO
        BINARY SEARCH FOR SMALLEST k for which array[k] + array[j] > array[i]
        counter -= j - k;
        IF nothingAddedInTheLastIteration DO
            BREAK;
        END_IF
    END_FOR
    IF nothingAddedInTheLastIteration DO
        BREAK;
    END_IF
END_FOR