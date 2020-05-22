public static int indexOf(int number, int digit)
 {
    int count = numDigits(number);
    for(int i = 1; i <= count; i++)
    {
        if(digit == getDigit(number, i))
            return i;
    }
    return -1;  //the digit was not found
 }