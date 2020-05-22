public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    List<Contact> phoneBook = new ArrayList<>();

    while (true) {
        System.out.println("Would you like to create a new contact? (Y/N)");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Enter the contact's first name: ");
            String first = scan.nextLine();

            System.out.println("Enter the contact's last name: ");
            String last = scan.nextLine();

            System.out.println("Enter the contact's phone number: ");
            String phone = scan.nextLine();

            Contact contact = new Contact(first, last, phone);
            phoneBook.add(contact);
            for (Contact c : phoneBook) {
                System.out.println(c);
            }
        } else {
            System.out.println("Goodbye!");
            break;
        }
    }

    scan.close();
}