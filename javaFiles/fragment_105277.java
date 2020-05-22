public static String createSocial() {
    String ls = System.lineSeparator();
    Scanner sc = new Scanner(System.in);
    String social = "";
    while (social.equals("")) {
        System.out.print("Please enter the last four digits of " + ls
                + "your Social Security Number: --> ");

        social = sc.nextLine();
        if (!social.matches("\\d{4}")) {
            System.err.println("Invalid Entry! Please Try Again..." + ls);
            social = "";
        }
    }
    return social;
}