Scanner scanner = new Scanner(System.in);

    String myString;
    boolean validInput;
    int number;

    do {
        System.out.println("Enter a single integer");
        myString = scanner.nextLine();
        try {
            number = Integer.parseInt(myString);
            validInput = true;
        } catch(NumberFormatException e) {
            validInput = false;
            number = -1;
        }
    }while (validInput == false);
    scanner.close();

    System.out.println(number);