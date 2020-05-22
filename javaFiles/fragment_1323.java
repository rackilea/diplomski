public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Input your text: ");
            String input = scanner.nextLine();
            printRhombusText(input);
            scanner.reset();
            System.out.print("You want to do one more? (y/n): ");
        } while (scanner.nextLine().trim().equals("y"));

    }