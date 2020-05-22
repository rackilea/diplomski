public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int input, sum = 0;
    System.out.print("Enter a positive integer number: ");
    input = s.nextInt();

        String outputString = ""; //our result string

    while (input != -1) {
            outputString += input + " "; //adding to the output string
            sum += input;
            System.out.print("Enter a positive integer number: ");
            input = s.nextInt();
    }

    System.out.println("Entered Number:\t" + outputString);
    System.out.println("The Sum:\t\t" + sum);
}