public static void main(String[] args) {

    Scanner game = new Scanner(System.in);

    while (true) {

        System.out.println("Enter another contestant (Y/N)?");
        String str = game.next();
        if (!str.equalsIgnoreCase("Y")) {
            break;
        }
    }

    System.out.println("I'm free");

}