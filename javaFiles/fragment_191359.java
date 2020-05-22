static final Scanner input = new Scanner(System.in);

public static void main(String[] args) {
    int number, result;
    System.out.println("Enter number:");
    number = input.nextInt();
    result = 0;
    System.out.print("The numbers: ");

    //Reverses the number
    int reversedNum = 0;
    while (number != 0) {
        reversedNum = reversedNum * 10 + number % 10;
        number = number / 10;
    }

    //Iterates over the number and prints it out
    while (reversedNum > 0) {
        System.out.print((reversedNum % 10));

        result = result + (reversedNum % 10);
        reversedNum = reversedNum / 10;

        if (reversedNum > 0) {
            System.out.print(" + ");
        }
    }
    System.out.println(" = " + result);
}