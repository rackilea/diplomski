if (input > 16 || input < 1) {
    System.out.println("Enter a number between 1-16");
}
else {

    for(int fibCount = 1; fibCount <= input; fibCount++)
    {
        int sequence = newNumber.Fibonacci(fibCount);
        System.out.print(sequence);
    } 
}