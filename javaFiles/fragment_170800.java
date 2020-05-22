while (true){
  userInput = JOptionPane.showInputDialog("1. Withdraw\n2. Deposit\n3. View Balance\n4. Exit");
  if (userInput == null) {
    JOptionPane.showMessageDialog(null, "Invalid Input\nPlease Try Again", "Cannot Cancel", JOptionPane.ERROR_MESSAGE);
    continue;
  }
  switch (userInput){

    case "1": ...