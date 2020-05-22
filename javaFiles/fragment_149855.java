public final class Menu {

    private Integer res;
    private boolean quit;

    public static Integer showMenuAndGetResult() {
        Menu menu = new Menu();
        menu.activate();
        return menu.res;
    }

    private Menu() {
    }

    private void activate() {
        try (Scanner in = new Scanner(System.in)) {
            show();

            while (!quit) {
                System.out.print("Choose menu item: ");
                int menuItem = in.nextInt();

                if (menuItem == 1)
                    onMenuItem1(in);
                else if (menuItem == 2)
                    onMenuItem2(in);
                else if (menuItem == 0)
                    onMenuQuit();
                else
                    System.out.println("Invalid choice.");
            }

            System.out.println("Bye-bye!");
        }
    }

    private void show() {
        for (int i = 1; i <= 3; i++)
            System.out.println(i + ". Menu item #" + i);

        System.out.println("0. Quit");
        System.out.println();
    }

    private void onMenuItem1(Scanner scan) {
        System.out.println("Default ");
        // TODO menu 1 logic incapsulation
    }

    private void onMenuItem2(Scanner scan) {
        System.out.println("Enter your number to play the song: ");
        // TODO menu 2 logic incapsulation
    }

    private void onMenuQuit() {
        res = null;
        quit = true;
    }

}