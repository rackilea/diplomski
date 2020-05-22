String scannedString = keyboard.nextLine();
    do {
        System.out.println("Numbers: "+scannedString); 
        scanz.set(scannedString);
        scanz.printState();
    } while (!(scannedString = keyboard.nextLine()).equals("."));