reset.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       // handle click on the "Reset" button
       for (int i = 0; i < 9; i++) {
           board[i].setText("");
           board[i].setEnabled(true);
           winner = false;
           Checkers[i] = "";
           value = 0;
           turn = 1;
       }
    }
});
exit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       // handle click on the "Exit" button
       System.exit(0);
    }
});