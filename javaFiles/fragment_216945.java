protected static void shiftRight(char character, char[] characters) {
    int indexOf = indexOf(character, characters);
    if (indexOf > 0) {
        char[] temp = Arrays.copyOfRange(characters, 0, indexOf);
        System.arraycopy(characters, indexOf, characters, 0, characters.length - indexOf);
        System.arraycopy(temp, 0, characters, characters.length - temp.length, temp.length);
    }
}