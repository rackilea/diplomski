public static float Compute(float Number)
{
    // define variable sqrRoot to hold the approximate square root
    float sqrRoot = 0;
    // define temporary variable temp to hold prior value of iteration
    float temp = 0;
    // divide variable num by 2 to start the iterative process
    // and assign the quotient to temp
    temp = Number/2;

    // open a while() loop that continues as long as num >= 0.0
    while (Number >= 0.0)    // <<<< you might reconsider this condition: iteration count?
    {
        // construct the main iterative statement
        sqrRoot = temp - (temp * temp - Number) / (2 * temp);

        // open an if block to check if the absolute value of the difference of
        // variables temp and sqrRoot is below a small sentinel value such as 0.0001
        // if this condition is true then break the loop
        float value;
        value = Math.abs(temp - sqrRoot);

        if (value < .0001)
            // return sqrRoot as the answer
            return sqrRoot;  // <<<<< this is the line you needed to change
        // if this condition is not true then assign sqrRoot to temp
        else temp = sqrRoot;
    } // close the while() loop

    return Number;  // <<<<< you will never reach this line
}