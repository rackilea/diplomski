int number = 0; // you need to initialize your variable first
while (true) {
    try {
    number = Integer.parseInt(keyboard.nextLine());
    break; // this will escape the while loop
    } catch (Exception e) {
    System.out.println("That is not a number. Try again.");
    }
}