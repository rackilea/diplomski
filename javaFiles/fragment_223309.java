int userInput;
Scanner scan = new Scanner(System.in);
while(true) {
    try {
        userInput = Integer.parseInt(scan.nextLine());
        break;
    } catch (NumberFormatException e) {
        System.out.println("Input Invalid! Try again!");
    }
}
// do stuff with userInput