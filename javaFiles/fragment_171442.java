public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    infoMenu man = new infoMenu();
    airMonMenu airmon = new airMonMenu();
    boolean exit = false;
    while (!exit) {
        System.out.println("\nPlease select which menu you'd like to      open...");
        System.out.println("To view information about the tools included type: 'i' ");
        System.out.println("To enter the airmon menu type: 'a'");
        System.out.println("To exit simply type: 'e'\n");
        char optSelect = (char) System.in.read(); //should be here
        switch (optSelect) {
        case 'i':
            man.infoMenu();
            break;
        case 'a':
            airmon.airMonMenu();
            break;
        case 'e':
            exit = true;

    }

}