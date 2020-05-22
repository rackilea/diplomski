class TicTacToe implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("TicTacToe.actionPerformed: " + e);
  }
  public static void main(String []args) 
  {
    new TicTacToe().popupintroscreen();
  }
  public void popupintroscreen() { // <-- not static.
    // ...
  }
}