public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String id;
    System.out.println("Please enter id: (length must be 10)");
    while ((id = sc.nextLine()).length() != 10)
        System.out.println("Length of id must be 10, try again: ");

    String pin;
    System.out.println("Please enter id: (length must be 10)");
    while ((pin = sc.nextLine()).length() != 4)
        System.out.println("Length of pin must be 4, try again: ");

    sc.close();

    Member foo = new Member("Peter", id, pin, 1000000);
}