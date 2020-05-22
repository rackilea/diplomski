boolean gotInteger = false;
    while (!gotInteger) {
        System.out.println("Please enter the integer you wish to show the table for");
        if (sc.hasNextInt()) {
            multiplier = sc.nextInt();
            gotInteger = true;
        } else {
            System.out.println("Input is not an integer\n");
        }
        sc.nextLine();
    }