public static void main(String [] args) {
        while(true) { //this in an infinite loop
            System.out.println("Press 1 for C->F or 2 for F->C 3 to Quit");
            converChoice = scan.nextInt();

            if (converChoice == 1)
                convertCtoFAndPrint();
            else if (converChoice == 2)
                convertFtoCAndPrint();
            else if (converChoice == 3) {
                System.out.println("The program will now terminate");
                System.exit(0);//this stops the program
            }
        }
    }