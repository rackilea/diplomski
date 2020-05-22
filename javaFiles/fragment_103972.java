// A function which returns the greatest common divisor.
private static int findGCD(int number1, int number2) { 
    //base case 
    if(number2 == 0){ 
        return number1; 
        } 
    // Returns the two numbers 
    return findGCD(number2, number1%number2); 
}