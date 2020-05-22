method(String textSoFar, int lettersLeft) {
    if (lettersLeft == 0)
        print textSoFar
    else
        for each letter in alphabet:
            method(textSoFar + letter, lettersLeft - 1)
}