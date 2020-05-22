public static int getYourPositiveFunctionRandomNumber(int startIndex, int stopIndex) {
    //Generate a random number whose value ranges from 0.0 to the sum of the values of yourFunction for all the possible integer return values from startIndex to stopIndex.
    double randomMultiplier = 0;
    for (int i = startIndex; i <= stopIndex; i++) {
        randomMultiplier += yourFunction(i);//yourFunction(startIndex) + yourFunction(startIndex + 1) + .. yourFunction(stopIndex -1) + yourFunction(stopIndex)
    }
    Random r = new Random();
    double randomDouble = r.nextDouble() * randomMultiplier;

    //For each possible integer return value, subtract yourFunction value for that possible return value till you get below 0.  Once you get below 0, return the current value.  
    int yourFunctionRandomNumber = startIndex;
    randomDouble = randomDouble - yourFunction(yourFunctionRandomNumber);
    while (randomDouble >= 0) {
        yourFunctionRandomNumber++;
        randomDouble = randomDouble - yourFunction(yourFunctionRandomNumber);
    }

    return yourFunctionRandomNumber;
}