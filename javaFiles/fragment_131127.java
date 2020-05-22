byte savedInput;
    boolean savedHasNextByte;
    while (!(savedHasNextByte = keyboard.hasNextByte()) || (savedInput = keyboard.nextByte()) <= 0) {
        if (!savedHasNextByte) keyboard.next();
        System.err.print("Error, try again: ");
    }