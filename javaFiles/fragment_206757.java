try {
    int value = Integer.parseInt(myString);
    // Yes!  An integer.
} catch (NumberFormatException nfe) {
    // Not an integer
}