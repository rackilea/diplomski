for (int i = 0; i < books.length; i++) {
    System.out.print("Enter book " + (i + 1) + " title: ");
    String title = input.nextLine();
    // NOT HERE. input.nextLine();
    System.out.println("Enter book " + (i + 1) + " author's name:");
    String name = input.nextLine();

    System.out.print("Enter book " + (i + 1) + " price: ");
    double price = input.nextDouble(); // next or nextFoo
    input.nextLine(); // Scanner is skipping nextLine

    System.out.println("Enter book " + (i + 1) + " author's email: ");
    String email = input.next(); // next or nextFoo
    input.nextLine(); // Scanner is skipping nextLine
    Author a = new Author(name, email);
    books[i] = new Book(title, price, a);
    System.out.println(books[i] + "\n");
}