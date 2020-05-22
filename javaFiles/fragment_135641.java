private class HandlerClass implements ActionListener {
  public void actionPerformed(ActionEvent event) {
     window1 wo1 = new window1();  // ***** problem is here *****
     int loggedU = wo1.loggedUser;
     System.out.println("action command: " + event.getActionCommand()); //!!
     System.out.println("loggedU: " + loggedU);
     if (event.getActionCommand().equals(garage)) {