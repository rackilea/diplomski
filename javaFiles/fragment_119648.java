public static void main(String[] args) {
    System.out.println("Enter the Limit:");
    Scanner ob = new Scanner(System.in);
    int limit = ob.nextInt();
    if (limit < 0) {
        System.out.println("Negative number! Enter proper value!");
    } else if (limit == 0) {
        System.out.println("Please enter a number greater than zero!");
    } else {
        for (int i = 1; i < limit; i++) {
            int sum = 0;
            int number = i;
            while (number != 0) {   // While loop to review each digit of the number
                int digit = number - (number / 10) * 10;    // Capturing the last digit
                sum += digit * digit * digit;               // Adding digit^3
                number = number / 10;                       // Dividing number to get the next digit
            }
            if (sum == i) {     // i is an Armstrong number
                System.out.println(i + " is an Armstrong number.");
            }
        }
        System.out.println("Limit finished!");
    }
}