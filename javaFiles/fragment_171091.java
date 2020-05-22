boolean hasError = true;
String integerRegex = "[\\d]+"; // it means 1-to-many digits
while (hasError) {
    System.out.println("Hello! Please enter how many Students you have in your class: ");
    String input = in.nextLine();
    if (input.matches(integerRegex)) {
        classSize = Integer.parseInt(input);
        hasError = false;
    } else {
        System.out.println("Invalid input. please make sure you enter numbers ONLY! No symbols or letters.");
        // variable hasError remains true
    }
}