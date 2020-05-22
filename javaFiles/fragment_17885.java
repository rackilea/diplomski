Scanner scan = new Scanner(System.in);
    String input;

    System.out.print("Your Value: ");

    while ((input = scan.nextLine()).matches("\\d+")){

        int total = 0;

        for(int i = 0; i < input.length(); i++) {
            total += Character.getNumericValue(input.charAt(i));
        }

        System.out.println("Your Result: "+ total);
        System.out.println("\nYour Value: ");
    }

    System.out.println("\nTHE END.");
    scan.close();