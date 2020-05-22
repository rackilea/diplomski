reset.addActionListener(e -> {
    // handle click on the "Reset" button
    for (int i = 0; i < 9; i++) {
        board[i].setText("");
        board[i].setEnabled(true);
        winner = false;
        Checkers[i] = "";
        value = 0;
        turn = 1;
    }
});
exit.addActionListener(e -> {
    // handle click on the "Exit" button
    System.exit(0);
});
item1.addActionListener(e -> {
    // handle click on the "1-vs-1" menu item
    ...
});
item2.addActionListener(e -> {
    // handle click on the "1-vs-computer" menu item
    ...
});