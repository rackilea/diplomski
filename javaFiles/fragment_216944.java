private static int indexOf(char character, char[] characters) {
    for (int i = 0; i < characters.length; i++) {
        if (characters[i] == character) {
            return i;
        }
    }

    return -1;
}