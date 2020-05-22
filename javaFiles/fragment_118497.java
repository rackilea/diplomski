public char letterGuessing() {
    String inputString;
    while (true) {
        System.out.print("Give a letter: ");
        inputString = scanner.nextLine();
        if (inputString != null && inputString.length() > 0 && Character.isLetter(inputString.charAt(0))) {
            break;
        }
    }

    return inputString.toUpperCase().charAt(0);
}