private int function getBasedOnInterval(int value) {
    int result = RESULT15;

    // consider LIMITS as an array containing 0, LIMIT1...LIMIT13
    // consider RESULTS as an array containing RESULT1...RESULT14
    for(int index = 0; index < LIMITS.length; index++) {
        if(value <= LIMITS[index]) {
            result = RESULTS[index];
            breaks;
        }
    }

    return result;
}