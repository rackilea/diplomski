private boolean CheckWinner(JButton source, String inplayer) {
    int buttonColumn = -1;
    for (int col = 0; col < EventBoard.length; col++) {
        for (JButton item : EventBoard[col]) {
            if (item == source) {
                buttonColumn = col;
                break;
            }
        }
    }
    boolean match = false;
    for (JButton item : EventBoard[buttonColumn]) {
        if (source != item && item.getText().equals(inplayer)) {
            match = true;
            break;
        }
    }
    return match;
}