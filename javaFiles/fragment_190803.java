String input = "";
while (true) {
    System.out.printf("Enter a word or 'end' to quit: ");
    String next = scanner.nextLine();

    if (next == null || next.length() == 0) {
        System.out.println("Invalid! Try again...");
        return;
    }

    if (next.equalsIgnoreCase("end")) {
        break;
    }

    input += next + " ";
}