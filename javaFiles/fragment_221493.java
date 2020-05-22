double exp(long base, long exponent) {

    //when the exponent is zero
    if (exponent == 0) return 1.0;

    long result = base;
    long exponent_abs = Math.abs(exponent);

    //repeating multiplication many times to achieve exponentiation
    for (int i = 2 ; i <= exponent_abs ; ++i) {

        result = multiply(result, base);
    }

     //if the exponent is positive, return result you found.
     if (exponent > 0) return result;
     //if it is negative, return a fraction.
     return 1/((double)result);
  }

//repeating addition many times to achieve multiplication.
long multiply(long number1, long number2){
    long result = number1;

    for (int i = 1; i < number2; ++i){
        result += number1;
    }
    return result;
 }