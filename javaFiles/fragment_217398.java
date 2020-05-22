String input;
int code;

while (true) {
    System.out.print("PIN: ");
    input = reader.nextLine();
    try {
        code = Integer.parseInt(input);
    } catch (NumberFormatException ignored) {
        // not an integer!
        System.out.println("Enter a valid PIN!");
        continue;
    }
    if (code == 8273)
        break;
    System.out.println("Access denied");
}

System.out.println("Access granted");