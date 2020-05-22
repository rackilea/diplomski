void match(String string) {
    int numIndex = -1;
    int charIndex = 0;

    if (string.length() > 0) {  
        while (numIndex == -1 && charIndex < string.length()) {
            if (Character.isDigit(string.charAt(charIndex)))
                numIndex = charIndex;
            charIndex++;
        }
    }

    if (numIndex != -1) {
        System.out.println(string.substring(0, numIndex));
        System.out.println(string.substring(numIndex));
    }

}