public static void main(String [] args) {
        do {
            System.out.println("Press 1 for C->F or 2 for F->C 3 to Quit");
            converChoice = scan.nextInt();

            if (converChoice == 1)
                convertCtoFAndPrint();
            else if (converChoice == 2)
                convertFtoCAndPrint();
            else if (converChoice == 3) {
                System.out.println("The program will now terminate");
                // System.exit(0); is no longer needed since the program exists the loop
            }
        } while (converChoice!=3);
    }