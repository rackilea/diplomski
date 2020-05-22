String scannedString = null;
    while (!(scannedString = keyboard.nextLine()).equals(".")) {
        System.out.println("Numbers: "+scannedString); 
        scanz.set(scannedString);
        scanz.printState();
    }