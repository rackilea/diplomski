public int addInt(int x, int y) throws InvalidValueException {
    if (x < 1 || y < 1) {
        throw new InvalidValueException();
    }
    return x + y;
}