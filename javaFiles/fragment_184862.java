public void add(int num) {
    // Possible but pointless; it will never throw
    exceptionCreator(num);
}

public void print(String something) {
    exceptionCreator(something);
}

public void gamePiece(CustomObject blah) {
    exceptionCreator(blah);
}

private void exceptionCreator(Object sample) {
    if (sample == null) {
        throw new IllegalArgumentException();
    }
}