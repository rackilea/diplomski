public int getIntegerFromInput(String s) throws BadInputException {
    int i = 0;
    try {
        i = Integer.parseInt(s);
    catch (NumberFormatException e) {
        throw new BadInputException();
    }

    return i;
}