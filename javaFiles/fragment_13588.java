Scanner in = new Scanner(System.in);

    int input = 0;

    while (input <= 1) {
        System.out.println("Give an int bigger than 1: ");
        input = in.nextInt();

        if (input <= 1) {
            System.out.println("The int must be bigger than 1!.");
        }
    }

    in.close();