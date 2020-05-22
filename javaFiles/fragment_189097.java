Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = 0;

        while (true) {
            try {
                number = Integer.parseInt(input);
                return;
            } catch (Exception e) {
                System.out.println("Invalid number");
            }
            input = scanner.nextLine();
        }