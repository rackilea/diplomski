Scanner input = new Scanner(System.in);
int number;
boolean isInt = false;
while (isInt == false) {

    System.out.println("Enter a number:");
    try {
        number = Integer.parseInt(input.nextLine());
        isInt = true;
    } catch (NumberFormatException error) {
        System.out.println("Error! You need to enter an integer!");
    }

}