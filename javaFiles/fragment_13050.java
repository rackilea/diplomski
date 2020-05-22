int index = -1;
        for (int i = enteredString.length() - 1; i >= 0; i--) {
            if (enteredString.charAt(i) == char1) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Character Not Found");
        } else {
            System.out.println("The index of character " + char1 + " in string " + enteredString + " is: " + index);
        }