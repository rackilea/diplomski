private static void makeUserUnderstand(Scanner input, String msg) {
    while (true) {
        System.out.println(msg);
        System.out.println("Do you understand? Type 'y' to continue\n");
        if (input.next().equals("y"))
            break;
    }
}