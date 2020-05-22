private void moveLeft(int amount) {
    int newPosition = txtAbc.getCaretPosition() - amount;
    txtAbc.setCaretPosition(newPosition < 0 ? 0 : newPosition);
}

private void moveRight(int amount) {
    int newPosition = txtAbc.getCaretPosition() + amount;
    txtAbc.setCaretPosition(newPosition > txtAbc.getText().length() ? txtAbc.getText().length() : newPosition);
}