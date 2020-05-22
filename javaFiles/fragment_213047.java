public static String passPhoneNumber() {
    String phoneNumber = "";
    Scanner scanner = new Scanner(System.in);
    do {
        System.out.println("Enter phone number (format 111222333): ");
        phoneNumber = scanner.nextLine();
    } while(!phoneNumberValidator(phoneNumber));
    scanner.close();
    return phoneNumber;
}