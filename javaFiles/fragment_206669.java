String value;

while (true) { // Repeat until a valid payrate is entered
    try {
        System.out.print("Enter payrate: "); // Ask for payrate

        value = input.nextLine();            // Get payrate as string
        payrate = Float.parseFloat(value);   // Convert the string to float

        if (payrate > 0) { // Valid payrate number (> 0), done
            break;
        } else {           // Invalid payrate number (<= 0), repeat
            System.out.println("Payrate must be > 0.");
        }
    } catch (NumberFormatException e) { // Payrate not a number, repeat
        System.out.println("Payrate must be a number.");
    }
}