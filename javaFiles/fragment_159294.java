public static String validName(Scanner input, Scanner histogram) {
    String user = "";
    String name = input.next();
    String tmp = "";
    boolean test = false;

    while (histogram.hasNext()) {
        user = histogram.next();
        tmp += user + " ";

        if (name.equalsIgnoreCase(user)) {
            test = true;
            break;
        }
        else {
            test = false;

        }
    }
    if (!test) {
        System.out.println("Name not found");
        user = validName(input, new Scanner(tmp));
    }
    return user;
}