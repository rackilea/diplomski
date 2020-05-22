@Override
public void actionPerformed(ActionEvent e) {
    JButton _buttonPressed = (JButton) e.getSource();

    _buttonPressed.setText("" + turn);
    _buttonPressed.setEnabled(false);
    if (turn == 'X') {
        turn = 'O';
    } else {
        turn = 'X';
    }
}