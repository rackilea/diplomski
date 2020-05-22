System.out.print("What letter do you want to replace?: ");
    readChar = keyboard.next();
    String changeChar;
    System.out.print("With what letter do you wish to replace it? ");
    changeChar = keyboard.next();
    System.out.println(word.replace(readChar, changeChar));