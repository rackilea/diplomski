int num1, num2 = 0;

try {
    System.out.println("Please enter two positive integers.");
    System.out.println("Please enter the first integer:");
    num1 = in.nextInt();

    if(num1 < 0) {
        System.out.println("Invalid integer. ***End of Program***");
        System.exit(0);

    } else {
        System.out.println("Please enter the second integer:");
        num2 = in.nextInt();

        if(num2 < 0) {
            System.out.println("Invalid integer. ***End of Program***");
            System.exit(0);
        }
} catch(InputMismatchException e) {
    System.out.println("That is not an integer. ***End of Program***");
    System.exit(0);
}
...