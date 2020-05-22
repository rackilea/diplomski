while (input != 0) {    
    last_digit = input % 10;
    if (last_digit % 2 != 0) {     
        reversedNum = reversedNum * 10 + last_digit;

    }
    input = input / 10; 
}