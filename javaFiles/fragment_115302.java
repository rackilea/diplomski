JOptionPane optionPane = new JOptionPane("body of the dialog");
optionPane.setWantsInput(true); //this is what I added
JDialog dialog = optionPane.createDialog("Title Of the Dialog");
dialog.setAlwaysOnTop(true);
dialog.setVisible(true);
dialog.dispose();
System.out.println(optionPane.getInputValue());