public String computeFrequency(String input) {
    int []frequecy = new int[128]; // each element of array represent frequency of some character indexed by character's ascii code
    for(char ch: input.toCharArray()) {
        int intCurrentChar = (int) ch;  // get ascii code of current character. It can be obtained by casting character to integer in java.
        frequecy[intCurrentChar]++; // increase the frequency of current character
    }

    // collect all non zero frequency to string
    StringBuilder sbr = new StringBuilder();
    for(int frequencyIndex = 0; frequencyIndex <128; frequencyIndex++) {
        if( frequecy[frequencyIndex]>0) {
            char ch = (char) frequencyIndex; // get ascii character from ascii code. It can be obtained by casting integer to character in java.
            sbr.append(ch).append(" ").append(System.lineSeparator());
        }
    }

    return sbr.toString();  
}