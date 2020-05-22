private void initializeBoard() {
   for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
         JButton button = new JButton();
         button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
         board[i][j] = button;
         button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(((JButton)e.getSource()).getText().equals("") &&       
                  hasWon == false) {
                  button.setText(currentPlayer);
                  if(currentPlayer.equals("X")) {
                     button.setForeground(Color.BLUE);
                  } else if (currentPlayer.equals("O")) {
                     button.setForeground(Color.RED);
                  }
                  hasWon();
                  choosePlayer();
               }
            }
         });
         pane.add(button);
      }
   }
}