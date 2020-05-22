public void actionPerformed(ActionEvent event) {
    JButton clicked = (JButton) event.getSource();
    if (turn == 0) {
        clicked.setText("X");
        turn++;
    }
    else {
        clicked.setText("O");
        turn--;
    }
}