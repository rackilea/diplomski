public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.print("Enter an integer between 100-999: ");
    int integer = in.nextInt();
    int reverse = 0;

    if (integer >= 100 && integer <= 999) {
        while(integer != 0)
        {
            reverse = reverse * 10;
            reverse = reverse + integer%10;
            integer = integer/10;
        }

        System.out.println("Reverse of the number is " + reverse);
    } else {
        System.out.print("Your number is not in the correct range, good bye");
    }

}