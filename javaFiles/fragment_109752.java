public class SomeClass {
    private static Scanner input;

    public static void main(String[] args) {

        input = new Scanner(System.in);
        System.out.print("Please enter a command (start or stop) : ");
        String scanner = input.nextLine();

        while (!"start".equals(scanner) && (!"stop".equals(scanner))) {
            System.out.print("Please try again : ");
            scanner = input.nextLine();
        }
        if ("start".equals(scanner)) {
            System.out.println("System is starting");
        } else if ("stop".equals(scanner)) {
            System.out.println("System is closing");
        }
    }
}