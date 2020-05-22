int sum = 0;
int smallest = Integer.MAX_VALUE;
int largest = Integer.MIN_VALUE;
int count = 0;   
while ((input = scan.nextInt()) >= 0) {
    count++;
    sum += input;
    // Alternative: smallest = Math.min(smallest, input)
    if (input < smallest) {
        smallest = input;
    }
    // Alternative: largest = Math.max(smallest, input)
    if (input > largest) {
        largest = input;
    }
} 
// Cast for count is just to force floating point division.
System.out.println("You entered " + count +
    " numbers averaging " + (sum / (double) count) + ".");
System.out.println("The smallest number is "+ smallest);
System.out.println("The largest number is " + largest);