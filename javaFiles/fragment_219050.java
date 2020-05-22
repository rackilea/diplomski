Scanner scanner = new Scanner(System.in);

    String myString;
    int tokens;
    int number;

    do {
        System.out.println("Enter a single integer");
        myString = scanner.nextLine();
        tokens = new StringTokenizer(myString, " ").countTokens();
        try {
            number = Integer.parseInt(myString);
        } catch(NumberFormatException e) {
            tokens = 0;
            number = -1;
        }
    }while (tokens != 1);
    scanner.close();

    System.out.println(number);