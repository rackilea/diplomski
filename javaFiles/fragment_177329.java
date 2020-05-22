public class Console {

    private int testint = 1;
    /**
     * @param args
     */
    public static void main(String[] args) {
        Console console = new Console();
        console = console.mainMenu(console);
        System.out.println("Application has been shut down");
    }

    private Console mainMenu(Console console) {
        System.out.println("Welcome to the console application");

        int selection = 0;

        do {
            System.out.println("[1] Create New Account");
            System.out.println("[2] Modify Account");
            System.out.println("[3] Access Account");
            System.out.println("[4] Quit");

            System.out.print("Insert selection: ");
            // selection = testint++;
            selection = ReadConsole.nextInt();
            switch (selection) {
            case 1: return console.submenu1(console);
            case 2: return console.submenu1(console);
            case 3: return console.submenu1(console);
            case 4: return console;
            default:
                System.out.println("The selection was invalid!");
            }
        } while (selection != 4);
        return console;
    }

    private Console submenu1(Console console) {
        System.out.println("Welcome to the SUBMENU");

        int selection = 0;

        do {
            System.out.println("[1] SUBMENU_1");
            System.out.println("[2] SUBMENU_2");
            System.out.println("[3] SUBMENU_3");
            System.out.println("[4] Return");

            System.out.print("Insert selection: ");
            //selection = ++testint;
            selection = ReadConsole.nextInt();

            switch (selection) {
            case 1: return console.submenu1(console);
            case 2: return console.submenu1(console);
            case 3: return console.submenu1(console);
            case 4: return console.mainMenu(console);
            default:
                System.out.println("The selection was invalid!");
            }
        } while (selection != 4);
        return console;
    }
}