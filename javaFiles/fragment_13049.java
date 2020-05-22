int index = 1;
    for (int i = 0; i < enteredString.length(); i++) {
        if (enteredString.charAt(i) == char1) {
            index = i;
            break;
        }
    }
    System.out.println("The index of character " + char1 + " in string " + enteredString + " is: " + index);