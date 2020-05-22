JOptionPane pane = new JOptionPane("Message", JOptionPane.QUESTION_MESSAGE,
        JOptionPane.OK_CANCEL_OPTION, null, null, null);
pane.setWantsInput(true);
JDialog dialog = pane.createDialog(null, "Title");
dialog.setLocation(0, 0);
dialog.setVisible(true);

String str = (String) pane.getInputValue();