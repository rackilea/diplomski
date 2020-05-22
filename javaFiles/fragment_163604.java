public void actionPerformed(ActionEvent e)
  {
     JButton currentButton = (JButton)e.getSource();
     int number = currentButton.getText().charAt(0) - '0';

     // do whatever with the number
  }