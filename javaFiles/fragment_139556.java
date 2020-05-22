public void actionPerformed(ActionEvent arg0) {
     GameBoard game = new GameBoard(); // **** local variable
     game.main(null);
     String newPlayerName = playersName.getText();
     Player player1 = new Player(newPlayerName); // **** local variable
}