static void amountOfCharsInSentence(String[] args) {
// Declare argument here -----------^^^^^^^^^^^^^
    int sum=0;
    for (String s: args) {  // `args` here is the argument to *this* function
        sum+=s.length();
    }
}

public static void main(String[] args) {
    amountOfCharsInSentence(args);
    // Pass it here --------^^^^
}