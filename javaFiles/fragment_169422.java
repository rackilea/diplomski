ModalDialog dialog = new ModalDialog();
dialog.setLocationRelativeTo(null);
dialog.setVisible(true);

Option selection = dialog.getSelection();
System.out.println("You choose " + selection);