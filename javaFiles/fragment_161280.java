public class Program {

    private final Scanner sc = new Scanner(System.in); // scanner extracted to class member

    private Field f;
    private Avatar a;

    public Program() {
        a = new Avatar();
        f = new Field(a);
        f.displayField();

        menu1();
    }

    public void swapItemMenu() {
        System.out.println("What equipment would you like to be active?");
        System.out.println("1 - Hoe, 2 - Watering Can, 3 - Sickle");
        int inp = sc.nextInt(); // use existing scanner
        a.swapTool(inp);

        // no closing
    }

    public void menu1() {
        char input;

        // scanner instantiated when the object is created

        do {
            input = sc.next().charAt(0);
            if (input == 'A' || input == 'a' || input == 'W' || input == 'w' || input == 'S' || input == 's' ||
                    input == 'D' || input == 'd')
                a.moveMe(input);
            if (input == 'Q' || input == 'q')
                swapItemMenu();
            if (input == 'E' || input == 'e')
                f.updateField();
            if (input == 'F' || input == 'f') {
                f.examineTile();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            f.displayField();
        } while (input != 'x');
        sc.close();
    }

}