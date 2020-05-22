public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Stack<String> stack = new Stack<>();

    while (true) {
        System.out.printf("Enter a word or 'end' to quit: ");
        String next = scanner.nextLine();

        if (next == null || next.length() == 0) {
            System.out.println("Invalid! Try again...");
            return;
        }

        if (next.equalsIgnoreCase("end")) {
            break;
        }

        stack.push(next);
    }

    System.out.println("You entered (in reverse):");

    while (!stack.isEmpty()) {
        System.out.println(stack.pop());
    }
}