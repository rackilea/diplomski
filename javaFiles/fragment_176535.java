public class Instructions {

    public static void main(String[] args) {

        // Print instructions...

        List<String> instructionsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = null;

        while (true) {

            do {
                System.out.println("Enter a direction");
                input = scanner.next();
            } while (!input.matches("L|R"));
            instructionsList.add(input);

            System.out.println("Enter a street name");
            input = scanner.next();
            if (input.matches("SCHOOL"))
                break;
            instructionsList.add(input);
        }

        scanner.close();

        System.out.print("From SCHOOL ");
        for (int i = instructionsList.size() - 1; i >= 0; i--) {
            if ((instructionsList.size() - i)%2 == 1)
                System.out.printf("turn %s to%n", instructionsList.get(i));
            else
                System.out.printf("%s, then ", instructionsList.get(i));
        }
        System.out.println("HOME");
    }
}