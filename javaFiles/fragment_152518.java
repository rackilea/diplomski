public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
             // Create board here, if needed
             createBoard();
             board.setVisible(true);
             // start a new game here
             startGame();
         }
     });
}