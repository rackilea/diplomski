if (e.getSource() == MyButton) {
   //MyButton = new JButton("Tryck För Gul!"); remove this line
  //otherwise every time new button object will be created.
    MyButton.setText("Tryck För Gul!");//to change the button text
    MyButton.setBackground(Color.BLUE);
}