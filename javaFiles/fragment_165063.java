Boolean running = true;
    System.out.println("Enter a Number: ");

    while (true) {
        while (!sc.hasNextInt()) {
            System.out.println("Try again, Enter a Number: "); //invalid entry
            sc.nextLine();
        }
        WriteToFile(output, Integer.toString(sc.nextInt()));
    }