public static String addBinary(){
 // The two input Strings, containing the binary representation of the two values:
    String input0 = "1010";
    String input1 = "10";

    // Use as radix 2 because it's binary    
    int number0 = Integer.parseInt(input0, 2);
    int number1 = Integer.parseInt(input1, 2);

    int sum = number0 + number1;
    return Integer.toBinaryString(sum); //returns the answer as a binary value;
}