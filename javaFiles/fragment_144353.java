try (Scanner parser = new Scanner(inputText)) {
        while (parser.hasNextLine()) {
            String nextLine = parser.nextLine();
            String[] strings = nextLine.split("\\s");
            // Here you can use any pattern to split the line
            String name = strings[0];
            String number = strings[1];
            System.out.printf("%s%n%s%n", name, number);
        }
    }