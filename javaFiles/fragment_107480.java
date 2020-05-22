Scanner input = new Scanner(System.in);
// Prompt the user for a "target value"
System.out.println("Enter target value");
int target = input.nextInt();
// Initialize a running sum
int sum = 0;
// While the sum is less than or equal to the target value
while (sum <= target) {
    // Prompt the user for a value
    System.out.println("Enter an Integer");
    // Add the value to the sum
    sum += input.nextInt();
    // Display the current sum
    System.out.println("The current sum is " + sum);
}
// Indicate loop has completed
System.out.println("Done.");