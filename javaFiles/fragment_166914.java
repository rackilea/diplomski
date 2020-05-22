private static  double  recursivemethod (double number){ // Add argument
    double number1=Double.pareseDouble(number.getText()); // Parse Double
    if (number1<=1)
       return number1;
    return recursivemethod(number-1);
}