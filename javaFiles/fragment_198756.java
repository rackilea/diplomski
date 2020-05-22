public static int getInvisibleCharactersCount(String inputWords) {
    int invisibleCharacters = 0;
    int decimalEquivalent = 0;

    char[] caInputWords = inputWords.toCharArray(); // Convert String input to char array
    int[] intArray = new int[caInputWords.length]; //<<-Create an int array of size of your char array
    int i= 0; //intializing your counter
    for(char asciiChar: caInputWords) {
        decimalEquivalent = (int) asciiChar; // Cast each char of the array to int

        // Put ints into an intArray
        intArray[i] = decimalEquivalent; 
        i++; //increment counter after each iteration


    }

    for(int ctr = 0; ctr < intArray.length; ctr++) {
        if((intArray[ctr] >= 0 && intArray[ctr] < 33) ||
        (intArray[ctr] >= 127 && intArray[ctr] < 161)) {
            invisibleCharacters++;
        }
    }

    return invisibleCharacters;
}