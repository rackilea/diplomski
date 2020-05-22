private boolean CheckWinner(JButton source, String inplayer) {
    //...
    if (EventBoard[i][j] != source && 
            EventBoard[i][j].getText().equals( inplayer )){
        JOptionPane.showMessageDialog(null, "copy");
        EventBoard[i][j].setText("");
    }