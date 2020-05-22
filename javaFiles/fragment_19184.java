public void addBoard() {
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            bt[i][j] = new JButton(); 
            bt[i][j].setIcon(new javax.swing.ImageIcon("icons/"+ board[i][j] +".png"));
                panel.add(bt[i][j);   
        }
    }