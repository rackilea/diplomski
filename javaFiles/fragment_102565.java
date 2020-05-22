for (int i = 0; i < userInput.length(); i++) {
    char c = userInput.charAt(i);
    if (vow.indexOf(c) != -1) {
        vowels++;
    } else if (conso.indexOf(c) != -1) {
        consonants++;
    } else {
        charac++; // invalid character
    }
}