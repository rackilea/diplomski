void example() {
    throw new UnsupportedOperationException("message");
}      // ^^^

void demonstration() {
    try {
       example();
    } catch (UnsupportedOperationException e) {
        e.printStackTrace();
    }
}