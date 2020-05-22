public static String ask(){
    Scanner input = new Scanner (System.in);

    System.out.println("Enter Password: ");
    password = input.nextLine();

    return password;
}