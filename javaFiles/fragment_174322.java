Scanner fileScanner = UIAuxiliaryMethods.askUserForInput().getScanner();

while (fileScanner.hasNext()) {
    // fileScanner.next();

    String inputPlayer = fileScanner.next();

    int thinkingTime = fileScanner.nextInt();