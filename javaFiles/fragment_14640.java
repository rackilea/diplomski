Scanner input = new Scanner(System.in);
    while (shouldContinue == true) {
        nameInput();
        shouldContinue = promptForContinue(input);
    }
    writeList(strList, input);