Open.setActionCommand("open");
Second.setActionCommand("second");

//...

public void actionPerformed(ActionEvent e) {
  String command = e.getActionCommand();
  if ("open".equals(command)) {
      //...
  } else if ("second".equals(command)) {
      //...
  }
}