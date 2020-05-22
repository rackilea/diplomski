boolean isMatch = true; 
    for (int counter = 0; counter < strLength && isMatch; counter++) {
        letter = word.charAt(counter);
        if (letter != 'I' && letter != 'O' && letter != 'S' && letter != 'H' && letter != 'Z' && letter != 'X' && letter != 'N') {
            System.out.print("NO");
            isMatch = false;
        } 
    }
    if (isMatch) {
        System.out.print("YES");
    }