// Compute integer power of 2.

    //Declare two primitive variables named 'e' and 'result' of type 'int' with no current 'value'
    int e, result;

    /*
     * Basic for-loop:
     * Instantiate an int named 'i' with 'value' 0
     * Set condition, until i(currently 0) is < 10 continue looping
     * After each loop, increment i by 1(i++), therefore i = i+1 after each loop
     */
    for(int i = 0; i < 10; i++) {
        result = 1; //Global variable 'result' is now with value 1
        e = i; //Global variable 'e' is now with value 1
        while(e > 0) { //Whilst the 'e' variable is > 0
            result = result * 2; //Multiply result(currently 1) by 2
            e--; //Decrement 'e' by 1 (e--) therefore 'e' is now e = e-1 after each loop
        }
        System.out.println("2 to the " + i + " power is " + result);
    }