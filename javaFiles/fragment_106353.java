int powTwo = 1;
int dec = 0;
// using the length of the string, start with a counter that is the length
// minus 1, decrement it by 1 until we get to 0
for (int i = someString.length() - 1; i >= 0; i--) {
    // Get the character at position i in the string
    char currentChar = someString.charAt(i);
    // Check for a "1"
    if (currentChar == '1') {
        dec += powTwo;
    }
    powTwo *= 2;
}