int evenCpt = 0; //To insert the even numbers one after the other
int fibonacciCpt = 0; //To iterate through the fibonacci numbers in array

for (; evenCpt < 90 && fibonacciCpt < 4000000; ++fibonacciCpt) {
    if (array[fibonacciCpt] % 2 == 0)
        evenArray[evenCpt++] = array[fibonacciCpt];
}